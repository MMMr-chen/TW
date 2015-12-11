package PosMachine;

import item.CartItem;
import org.junit.Before;
import org.junit.Test;
import promotion.DiscountPromotion;
import promotion.SecondHalfProm;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PromotionStrategyTest {
    private PromotionStrategy promotionStrategy;
    private CartItem cartItem;
    @Before
    public void setUp(){
        Map<String, DiscountPromotion> discountPromotionMap=new HashMap<String, DiscountPromotion>();
        Map<String, SecondHalfProm> secondHalfPromMap=new HashMap<String, SecondHalfProm>();
        discountPromotionMap.put("ITEM0001",new DiscountPromotion(50));
        discountPromotionMap.put("ITEM0002",new DiscountPromotion(50));
        secondHalfPromMap.put("ITEM0002",SecondHalfProm.getSecondHalfProm());
        secondHalfPromMap.put("ITEM0003",SecondHalfProm.getSecondHalfProm());
        promotionStrategy=new PromotionStrategy(discountPromotionMap,secondHalfPromMap);
    }
    @Test
    public void discountPromotionApplyTest(){
        cartItem=new CartItem("ITEM0001",3);
        double price=promotionStrategy.promotionCaculate(cartItem,50);
        assertThat(price,is(75d));

    }
    @Test
    public void secondHalfPromotionApplyTest(){
        cartItem=new CartItem("ITEM0003",3);
        double price=promotionStrategy.promotionCaculate(cartItem,50);
        assertThat(price,is(125d));
    }
    @Test
    public void multiplePromotionApplyTest(){
        cartItem=new CartItem("ITEM0002",3);
        double price=promotionStrategy.promotionCaculate(cartItem,100);
        assertThat(price,is(125d));
    }
    @Test
    public void nonPromotionApplyTest(){
        cartItem=new CartItem("ITEM0005",3);
        double price=promotionStrategy.promotionCaculate(cartItem,100);
        assertThat(price,is(300d));
    }


}