package manager;

import io_file.IOFile;
import shop_item.User;
import java.util.List;

public class UserManager implements ManagerList<User> {
    private final List<User> users;
    private final String path = "src/file/users";
    private final IOFile<User> ioFile;

    public UserManager() {
        ioFile = new IOFile<>();
        users = ioFile.readFile(path);
        if (users.isEmpty()) {
            User ADMIN = new User("admin", "123456");
            ADMIN.setRole("ADMIN");
            users.add(ADMIN);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByName(String name) {
        User user = null;
        for (User u : users) {
            if (u.getUserName().equals(name)) {
                user = u;
            }
        }
        return user;
    }

    public void saveUserList() {
        ioFile.writeToFile(users, path);
    }

    @Override
    public void add(User user) {
        users.add(user);
        ioFile.writeToFile(users, path);
    }

    public boolean checkExistUsername(String name) {
        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAdmin(String[] data) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())
                && user.getRole().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUser(String[] data) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())
                && user.getRole().equals("USER")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }
}
