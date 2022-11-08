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

    public void saveData() {
        product.saveProductList();
        user.saveUserList();
        cart.saveCartList();
        bill.saveBillsList();
    }

    public void loadData() {
        product.readProductList();
        user.readUserList();
        cart.readCartList();
        bill.readBillsList();
    }

    public void reload() {
        saveData();
        loadData();
    }
}
