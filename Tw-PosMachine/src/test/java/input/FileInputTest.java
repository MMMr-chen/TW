package input;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileInputTest {
    private FileInput fileInput;
    @Before
    public void setUp(){
        fileInput=new FileInput();
    }
    @Test
    public void getCorrectInputTest() throws IOException {
        File file=new File("");
        fileInput.readFile("/git/Tw-PosMachine/src/test/resources/cartlist.txt");
        List<String> list=fileInput.getList();
        assertThat(list.size(),is(3));
    }
}