package paser;

import item.CartItem;
import item.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemParserTest {
    private ItemParser itemParser;
    @Before
    public void setUp(){
        itemParser=new ItemParser();
    }
    @Test
    public void shouldGetOneCartItemTest(){
        List<String> list=asList("ITEM0001:2");
        List<Item> itemList=itemParser.parser(list);
        assertThat(itemList.size(),is(1));
        assertThat(itemList.get(0).getBarcode(),is("ITEM0001"));
        assertThat(itemList.get(0).getPrice(),is(2d));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionTest(){
        List<String > list=asList("IT123809aslj");
        itemParser.parser(list);
    }
    @Test
    public void shouldGetMultipleCartItemTest(){
        List<String> list=asList("ITEM0001:2","ITEM0003:2","ITEM0005:4");
        List<Item> itemList=itemParser.parser(list);
        assertThat(itemList.size(),is(3));
        assertThat(itemList.get(0).getBarcode(),is("ITEM0001"));
        assertThat(itemList.get(0).getPrice(),is(2d));
        assertThat(itemList.get(1).getBarcode(),is("ITEM0003"));
        assertThat(itemList.get(1).getPrice(),is(2d));
        assertThat(itemList.get(2).getBarcode(),is("ITEM0005"));
        assertThat(itemList.get(2).getPrice(),is(4d));
    }

}