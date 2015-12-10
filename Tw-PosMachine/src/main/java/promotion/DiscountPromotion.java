package promotion;

import item.CartItem;

public class DiscountPromotion extends Promotion {
    private int discountrate;
    public DiscountPromotion(int discountrate){
        this.discountrate=discountrate;
    }
    @Override
    public double apply(CartItem cartItem) {
        double price=cartItem.getTempprice()*discountrate/100;
        cartItem.setTempprice(price);
        return price*cartItem.getCount();
    }
}
