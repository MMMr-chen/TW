package promotion;

import item.CartItem;
import paser.SecondHalfParser;

public class SecondHalfProm extends Promotion{
    private SecondHalfProm(){}
    private static SecondHalfProm secondHalfProm=new SecondHalfProm();
    @Override
    public double apply(CartItem cartItem) {
        double price=cartItem.getTempprice();
        int promotion=cartItem.getCount()/2;
        return price*cartItem.getCount()-promotion*price/2;
    }
    public static SecondHalfProm getSecondHalfProm(){return secondHalfProm;}
}
