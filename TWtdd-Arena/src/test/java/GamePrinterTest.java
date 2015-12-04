import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by czh on 15-11-30.
 */
public class GamePrinterTest {
    private ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    public void gamePrinterPrintTest(){
        String outStr="1234567abcd";
        new GamePrinter().print(outStr);
        assertThat(outputStream.toString(),is("1234567abcd\n"));
    }

}