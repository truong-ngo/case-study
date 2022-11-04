package manager;

import user.User;

import java.io.Serializable;

public class GeneralManager {
    private ProductManager productManager;
    private UserManager userManager;
    private CartManager cartManager;

    public GeneralManager() {
        productManager = new ProductManager();
        userManager = new UserManager();
        cartManager = new CartManager();
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public CartManager getCartManager() {
        return cartManager;
    }
}
