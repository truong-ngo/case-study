package manager;

import io_file.IOFile;
import user.Cart;
import user.User;

import java.io.Serializable;
import java.util.List;

public class CartManager implements ManagerList<Cart> {
    private final List<Cart> carts;
    private final IOFile<Cart> ioFile;
    private final String path = "src/file/carts";

    public CartManager() {
        ioFile = new IOFile<>();
        carts = ioFile.readFile(path);
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public Cart getCartByUser(User user) {
        for (Cart cart : carts) {
            if (cart.getCartId().getUserName().equals(user.getUserName())) {
                return cart;
            }
        }
        return null;
    }

    public void saveCartList() {
        ioFile.writeToFile(carts,path);
    }

    @Override
    public void add(Cart item) {
        carts.add(item);
        ioFile.writeToFile(carts, path);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
