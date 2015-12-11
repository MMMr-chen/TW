package paser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class Parser<T> {
    public List<T> parser(List<String> input) throws Exception {
        List<T> resultlist=new ArrayList<T>();
        for (String line:input){
            validateInput(line);
            resultlist.add(paserLine(line));
        }
        return resultlist;
    }

    private void validateInput(final String line) throws Exception {
        if (!getPattern().matcher(line).matches()) {
            throw new Exception("invalid input");
        }
    }

    protected abstract T paserLine(String line);

    public abstract Pattern getPattern();
}
