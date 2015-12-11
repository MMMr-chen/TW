package PosMachine;

import item.CartItem;
import promotion.DiscountPromotion;
import promotion.Promotion;
import promotion.SecondHalfProm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionStrategy {
    private Map<String, DiscountPromotion> discountPromotionMap;
    private Map<String, SecondHalfProm> secondHalfPromMap;
    private List<Promotion> promotionList=new ArrayList<Promotion>();
    public PromotionStrategy(Map<String, DiscountPromotion> discountPromotionMap,
                             Map<String, SecondHalfProm> secondHalfPromMap){
        this.discountPromotionMap=discountPromotionMap;
        this.secondHalfPromMap=secondHalfPromMap;
    }
    public double promotionCaculate(CartItem cartItem,double price){
        cartItem.setTempprice(price);
        double subtotal=price*cartItem.getCount();
        getPromotionList(cartItem);
        for (Promotion promotion:promotionList){
            subtotal=promotion.apply(cartItem);
        }
        return subtotal;
    }

    private List<Promotion> getPromotionList(CartItem cartItem) {
        String barcode=cartItem.getBarcode();
        if (discountPromotionMap.containsKey(barcode)){
            promotionList.add(discountPromotionMap.get(barcode));
        }
        if (secondHalfPromMap.containsKey(barcode)){
            promotionList.add(secondHalfPromMap.get(barcode));
        }
        return promotionList;
    }
}
