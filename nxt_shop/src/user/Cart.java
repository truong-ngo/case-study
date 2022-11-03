package user;

import product.Product;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Cart implements Serializable {
    private User cartId;
    private Map<Product, Integer> cart;
    private Map<Product, Integer> bill;

    public Cart(User user) {
        cartId = user;
        cart = new TreeMap<>();
        bill = new TreeMap<>();
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

    public Map<Product, Integer> getBill() {
        return bill;
    }

    public void setBill(Map<Product, Integer> bill) {
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
