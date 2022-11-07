package manager;

public class Manager {
    public final ProductManager product;
    public final UserManager user;
    public final CartManager cart;
    public final BillManager bill;
    public final ChatManager chat;

    public Manager() {
        product = new ProductManager();
        user = new UserManager();
        cart = new CartManager();
        bill = new BillManager();
        chat = ChatManager.getInstance();
    }
}
