package user;

import product.Product;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Cart implements Serializable {
    private User cartId;
    private Map<Product, Integer> cart;
    private Map<Product, Integer> bill;

    public Cart() {
        cart = new TreeMap<>();
        bill = new TreeMap<>();
    }
}
