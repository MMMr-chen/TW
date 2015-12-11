package paser;

import org.junit.Before;
import org.junit.Test;
import promotion.DiscountPromotion;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiscountParserTest {
    private DiscountParser discountParser;
    @Before
    public void setUp(){
        discountParser =new DiscountParser();
    }
    @Test
    public void shouldGetOnePromotionTest() throws Exception {
        List<String> list=asList("ITEM0001:75");
        Map<String, DiscountPromotion> result=discountParser.parser(list);
        assertThat(result.size(),is(1));
        assertThat(result.containsKey("ITEM0001"),is(true));

    }
    @Test
    public void shouldGetMultiplePromotionTest() throws Exception {
        List<String> list=asList("ITEM0001:75","ITEM0005:90","ITEM00011:10");
        Map<String, DiscountPromotion> result=discountParser.parser(list);
        assertThat(result.size(),is(3));
        assertThat(result.containsKey("ITEM0001"),is(true));
        assertThat(result.containsKey("ITEM0005"),is(true));
        assertThat(result.containsKey("ITEM00011"),is(true));
    }
    @Test(expected = Exception.class )
    public void shouldThrowExceptionTest() throws Exception {
        List<String> list=asList("ITEm0901");
        discountParser.parser(list);
    }

}