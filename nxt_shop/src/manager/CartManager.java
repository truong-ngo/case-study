package manager;

import io_file.IOFile;
import shop_item.UserCart;
import shop_item.User;

import java.util.List;

public class CartManager implements CRUD<UserCart> {
    private static CartManager instance;
    private List<UserCart> userCartList;
    private final IOFile<UserCart> ioFile;
    private final String path = "src/file/carts";

    private CartManager() {
        ioFile = new IOFile<>();
        userCartList = ioFile.readFile(path);
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public UserCart getCartByUser(User user) {
        for (UserCart cart : userCartList) {
            if (cart.getCartID().getUsername().equals(user.getUsername())) {
                return cart;
            }
        }
        return null;
    }

    public void saveUserCartList() {
        ioFile.writeToFile(userCartList,path);
    }

    @Override
    public void add(UserCart item) {
        userCartList.add(item);
        ioFile.writeToFile(userCartList, path);
    }

    @Override
    public void update(int id, UserCart cart) {

    }

    @Override
    public void delete(int id) {

    }
}
