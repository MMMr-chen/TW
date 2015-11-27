import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by czh on 15-11-27.
 */
public class NumberCompareTest {
    @Test
    public void NumberCompareTest_1() throws Exception{
        String inputnumber="1234";
        String resnumber="4321";
        String result=NumberCompare.numberCompare(inputnumber,resnumber);
        assertThat(result,is("0A4B"));
    }
    @Test
    public void NumberCompareTest_2() throws Exception{
        String inputnumber="1234";
        String resnumber="1243";
        String result=NumberCompare.numberCompare(inputnumber,resnumber);
        assertThat(result,is("2A2B"));
    }
    @Test
    public void NumberCompareTest_3() throws Exception{
        String inputnumber="1234";
        String resnumber="1234";
        String result=NumberCompare.numberCompare(inputnumber,resnumber);
        assertThat(result,is("4A0B"));
    }
    @Test
    public void NumberCompareTest_4() throws Exception{
        String inputnumber="1234";
        String resnumber="5678";
        String result=NumberCompare.numberCompare(inputnumber,resnumber);
        assertThat(result,is("0A0B"));
    }
    @Test
        public void NumberCompareTest_5() throws Exception{
            String inputnumber="1234";
            String resnumber="1256";
            String result=NumberCompare.numberCompare(inputnumber,resnumber);
            assertThat(result,is("2A0B"));
        }
    @Test
    public void NumberCompareTest_6() throws Exception{
            String inputnumber="1234";
            String resnumber="2156";
            String result=NumberCompare.numberCompare(inputnumber,resnumber);
            assertThat(result,is("0A2B"));
        }
    }

