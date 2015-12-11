package PosMachine;

import input.FileInput;
import input.UserInput;
import item.CartItem;
import item.Item;
import paser.CartParser;
import paser.DiscountParser;
import paser.ItemParser;
import paser.SecondHalfParser;
import promotion.DiscountPromotion;
import promotion.SecondHalfProm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Pos {
    private List<Item> itemList;
    private List<CartItem> cartItemList;
    private Map<String, DiscountPromotion> discountPromotionMap;
    private Map<String , SecondHalfProm> secondHalfPromMap;
    private PromotionStrategy promotionStrategy;
    public void loaddata(String itempath,String cartpath,String dispath,String secpropath) throws Exception {
        FileInput fileInput=new FileInput();
        fileInput.readFile(itempath);
        itemList=new ItemParser().parser(fileInput.getList());
        fileInput.readFile(cartpath);
        cartItemList=new CartParser().parser(fileInput.getList());
        fileInput.readFile(dispath);
        discountPromotionMap=new DiscountParser().parser(fileInput.getList());
        fileInput.readFile(secpropath);
        secondHalfPromMap=new SecondHalfParser().parser(fileInput.getList());
        promotionStrategy=new PromotionStrategy(discountPromotionMap,secondHalfPromMap);
    }
    public double caculate() throws Exception {
        double total=0;
        for (CartItem cartItem:cartItemList){
            double price=queryItemPrice(cartItem.getBarcode());
            total+=promotionStrategy.promotionCaculate(cartItem,price);

        }
        return total;
    }
    private double queryItemPrice(String barcode) throws Exception {
        for (Item item : itemList) {
            if (item.getBarcode().equals(barcode)) {
                return item.getPrice();
            }
        }
        throw new Exception("No Item information");
    }
}
