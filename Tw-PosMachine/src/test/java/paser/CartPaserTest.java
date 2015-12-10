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
    public void shouldGetOneCartItemTest(){
        List<String> list=asList("ITEM0001-2");
        List<CartItem> cartItemList=cartParser.parser(list);
        assertThat(cartItemList.size(),is(1));
        assertThat(cartItemList.get(0).getBarcode(),is("ITEM0001"));
        assertThat(cartItemList.get(0).getCount(),is(2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionTest(){
        List<String > list=asList("IT123809aslj");
        cartParser.parser(list);
    }
    @Test
    public void shouldGetMultipleCartItemTest(){
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