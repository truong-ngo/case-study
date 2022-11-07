package shop_item;

import product.Product;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserCart implements Serializable {
    private static final long serialVersionUID = 42L;
    private final User cartID;
    private final Map<Product, Integer> cart;

    public UserCart(User user) {
        cartID = user;
        cart = new TreeMap<>();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public User getCartID() {
        return cartID;
    }

    public void addToCart(Product product, int quantity) {
        int value = 0;
        Set<Product> keys = cart.keySet();
        for (Product key : keys) {
            if (key.getName().equals(product.getName())) {
                value = cart.get(key);
            }
        }
        if (value == 0)  {
            cart.put(product, quantity);
        } else {
            cart.put(product, Math.min(value + quantity, product.getQuantity()));
        }
    }

    public int getCartAmount() {
        int amount = 0;
        Set<Product> keys = cart.keySet();
        for (Product key : keys) {
            amount += key.getPrice() * cart.get(key);
        }
        return amount;
    }
}
