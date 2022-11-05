package manager;

public class GeneralManager {
    public final ProductManager product;
    public final UserManager user;
    public final CartManager cart;
    public final BillManager bill;

    public GeneralManager() {
        product = new ProductManager();
        user = new UserManager();
        cart = new CartManager();
        bill = new BillManager();
    }

    public ProductManager getProduct() {
        return product;
    }

    public UserManager getUser() {
        return user;
    }

    public CartManager getCart() {
        return cart;
    }

    public BillManager getBill() {
        return bill;
    }
}
