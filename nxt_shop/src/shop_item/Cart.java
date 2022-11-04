package shop_item;

import product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart implements Serializable {
    private static final long serialVersionUID = 42L;
    private final User cartId;
    private Map<Product, Integer> cart;
    private Map<Map<Product, Integer>, LocalDateTime> bill;

    public Cart(User user) {
        cartId = user;
        cart = new HashMap<>();
        bill = new HashMap<>();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public User getCartId() {
        return cartId;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Map<Map<Product, Integer>, LocalDateTime> getBill() {
        return bill;
    }

    public void setBill(Map<Map<Product, Integer>, LocalDateTime> bill) {
        this.bill = bill;
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

    public void removeFromCart(Product product) {
        cart.remove(product);
    }


}
