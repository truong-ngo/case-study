package manager;

public class Manager {
    public final ProductManager product;
    public final UserManager user;
    public final CartManager cart;
    public final BillManager bill;
    public final ChatManager chat;

    public Manager() {
        product = ProductManager.getInstance();
        user = UserManager.getInstance();
        cart = CartManager.getInstance();
        bill = BillManager.getInstance();
        chat = ChatManager.getInstance();
    }
}
