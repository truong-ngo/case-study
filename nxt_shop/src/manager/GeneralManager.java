package manager;

public class GeneralManager {
    private final ProductManager productManager;
    private final UserManager userManager;
    private final CartManager cartManager;
    private final BillManager billManager;

    public GeneralManager() {
        productManager = new ProductManager();
        userManager = new UserManager();
        cartManager = new CartManager();
        billManager = new BillManager();
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

    public BillManager getBillManager() {
        return billManager;
    }
}
