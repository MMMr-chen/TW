package PosMachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PosTest {
    private Pos pos;

    @Before
    public void setUp() throws Exception {
        String itempath="src/test/resources/itemlist";
        String cartpath="src/test/resources/cartlist";
        String discountpath="src/test/resources/discountlist";
        String halfpath="src/test/resources/halflist";
        pos=new Pos();
        pos.loaddata(itempath,cartpath,discountpath,halfpath);
    }
    @Test
    public void getCorrectTotalTest() throws Exception {
        assertThat(pos.caculate(),is(258d));
    }

}