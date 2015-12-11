package paser;

import item.CartItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CartPaserTest {
    private CartParser cartParser;
    @Before
    public void setUp(){
        cartParser=new CartParser();
    }
    @Test
    public void shouldGetOneCartItemTest() throws Exception {
        List<String> list=asList("ITEM0001-2");
        List<CartItem> cartItemList=cartParser.parser(list);
        assertThat(cartItemList.size(),is(1));
        assertThat(cartItemList.get(0).getBarcode(),is("ITEM0001"));
        assertThat(cartItemList.get(0).getCount(),is(2));
    }
    @Test(expected = Exception.class)
    public void shouldThrowExceptionTest() throws Exception {
        List<String > list=asList("IT123809aslj");
        cartParser.parser(list);
    }
    @Test
    public void shouldGetMultipleCartItemTest() throws Exception {
        List<String> list=asList("ITEM0001-2","ITEM0003-2","ITEM0005-4");
        List<CartItem> cartItemList=cartParser.parser(list);
        assertThat(cartItemList.size(),is(3));
        assertThat(cartItemList.get(0).getBarcode(),is("ITEM0001"));
        assertThat(cartItemList.get(0).getCount(),is(2));
        assertThat(cartItemList.get(1).getBarcode(),is("ITEM0003"));
        assertThat(cartItemList.get(1).getCount(),is(2));
        assertThat(cartItemList.get(2).getBarcode(),is("ITEM0005"));
        assertThat(cartItemList.get(2).getCount(),is(4));
    }

}