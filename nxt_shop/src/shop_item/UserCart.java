package shop_item;

import product.Product;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserCart implements Serializable {
    private static final long serialVersionUID = 42L;
    private final User cartId;
    private final Map<Product, Integer> cart;

    public UserCart(User user) {
        cartId = user;
        cart = new TreeMap<>();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public User getCartId() {
        return cartId;
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
}
