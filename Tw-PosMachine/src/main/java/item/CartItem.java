package item;

import java.security.SecureRandom;

public class CartItem {
    private String barcode;
    private int count;
    private double tempprice=0;
    public  CartItem(String barcode,int count){
        this.barcode=barcode;
        this.count=count;
    }
    public int getCount(){
        return count;
    }
    public String getBarcode(){
        return barcode;
    }

    public double getTempprice(){
        return tempprice;
    }
    public void setTempprice(double tempprice){
        this.tempprice=tempprice;
    }
}
