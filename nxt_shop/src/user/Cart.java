package user;

import product.Product;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Cart implements Serializable {
    private User cartId;
    private Map<Product, Integer> cart;
    private Map<Product, Integer> bill;

    public Cart(User user) {
        this.cartId = user;
        cart = new TreeMap<>();
        bill = new TreeMap<>();
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, quantity);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }
}
