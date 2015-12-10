package promotion;

import item.CartItem;
import item.Item;

public abstract class Promotion {
    public abstract double apply(CartItem cartItem);
}
