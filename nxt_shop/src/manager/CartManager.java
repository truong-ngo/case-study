package manager;

import io_file.IOFile;
import shop_item.Cart;
import shop_item.User;

import java.util.List;

public class CartManager implements CRUD<Cart> {
    private static CartManager instance;
    private List<Cart> cartList;
    private final IOFile<Cart> ioFile;
    private final String path = "C:\\Learning\\Case-study\\file\\carts";

    private CartManager() {
        ioFile = new IOFile<>();
        cartList = ioFile.readFile(path);
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public Cart getCartByUser(User user) {
        for (Cart cart : cartList) {
            if (cart.getCartID().getUsername().equals(user.getUsername())) {
                return cart;
            }
        }
        return null;
    }

    public void saveCartList() {
        ioFile.writeToFile(cartList,path);
    }

    public void readCartList() {
        cartList = ioFile.readFile(path);
    }

    @Override
    public void add(Cart item) {
        cartList.add(item);
        ioFile.writeToFile(cartList, path);
    }

    @Override
    public void update(int id, Cart cart) {

    }

    @Override
    public void delete(int id) {

    }
}
