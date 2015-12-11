package paser;

import org.junit.Before;
import org.junit.Test;
import promotion.SecondHalfProm;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SecondHalfParserTest {
    private SecondHalfParser secondHalfParser;
    @Before
    public void setUp(){
        secondHalfParser=new SecondHalfParser();
    }
    @Test
    public void shouldGetOnePromotionTest() throws Exception {
        List<String> list=asList("ITEM0001");
        Map<String, SecondHalfProm> result=secondHalfParser.parser(list);
        assertThat(result.size(),is(1));
        assertThat(result.containsKey("ITEM0001"),is(true));

    }
    @Test
    public void shouldGetMultiplePromotionTest() throws Exception {
        List<String> list=asList("ITEM0001","ITEM0005","ITEM00011");
        Map<String, SecondHalfProm> result=secondHalfParser.parser(list);
        assertThat(result.size(),is(3));
        assertThat(result.containsKey("ITEM0001"),is(true));
        assertThat(result.containsKey("ITEM0005"),is(true));
        assertThat(result.containsKey("ITEM00011"),is(true));
    }
    @Test(expected = Exception.class )
    public void shouldThrowExceptionTest() throws Exception {
        List<String> list=asList("2131423:12");
        secondHalfParser.parser(list);
    }

}