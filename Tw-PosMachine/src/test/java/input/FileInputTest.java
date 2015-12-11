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
        fileInput.readFile("src/test/resources/cartlist");
        List<String> list=fileInput.getList();
        assertThat(list.size(),is(3));
        assertThat(list.get(0),is("ITEM000001-3"));
        assertThat(list.get(1),is("ITEM000003-2"));
        assertThat(list.get(2),is("ITEM000005-2"));

    }
}