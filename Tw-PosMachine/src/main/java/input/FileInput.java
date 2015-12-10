package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements UserInput {
    private  List<String> inputList=new ArrayList<String>();
    public void readFile(String path) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            inputList.add(line);
        }
        bufferedReader.close();

    }
    @Override
    public List<String> getList() {
        return inputList;
    }
}
