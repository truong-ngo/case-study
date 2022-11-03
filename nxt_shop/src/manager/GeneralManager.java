package manager;

import user.User;

public class GeneralManager {
    private ProductManager productManager;
    private UserManager userManager;

    public GeneralManager() {
        productManager = new ProductManager();
        userManager = new UserManager();
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
