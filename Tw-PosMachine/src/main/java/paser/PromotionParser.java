package paser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class PromotionParser<T> {
    private Pattern pattern;
    public Map<String,T> parser(List<String> input){
        Map<String,T> result=new HashMap<String,T>();
        for (String line:input){
            validateInput(line);
            result.put(parserLineCode(line),parserLine(line));
        }
        return result;
    }

    protected abstract String parserLineCode(String line);

    private void validateInput(String line) {
        if (!getPattern().matcher(line).matches()) {
            throw new IllegalArgumentException("invalid input format");
        }
    }

    protected abstract T parserLine(String line);

    public Pattern getPattern() {
        return pattern;
    }
}
