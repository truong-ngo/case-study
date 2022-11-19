package manager;

import io_file.IOFile;
import shop_item.User;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private List<User> users;
    private final String path = "../file/users";
    private final IOFile<User> ioFile;

    private UserManager() {
        ioFile = new IOFile<>();
        users = ioFile.readFile(path);
        if (users.isEmpty()) {
            User ADMIN = new User("admin", "123456");
            ADMIN.setRole("ADMIN");
            users.add(ADMIN);
        }
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User getAdmin() {
        for (User user : users) {
            if (user.getRole().equals("ADMIN")) {
                return user;
            }
        }
        return null;
    }

    public void saveUserList() {
        ioFile.writeToFile(users, path);
    }

    public void readUserList() {
        users = ioFile.readFile(path);
    }

    public void add(User user) {
        users.add(user);
        ioFile.writeToFile(users, path);
    }

    public boolean checkExistUsername(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAdmin(String[] data) {
        for (User user : users) {
            if (data[0].equals(user.getUsername()) && data[1].equals(user.getPassword())
                && user.getRole().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUser(String[] data) {
        for (User user : users) {
            if (data[0].equals(user.getUsername()) && data[1].equals(user.getPassword())
                && user.getRole().equals("USER")) {
                return true;
            }
        }
        return false;
    }

    public void update(String[] newInformation, User user) {
        for (User u : users) {
            if (u.equals(user)) {
                u.setEmail(newInformation[0]);
                u.setPhoneNumber(newInformation[1]);
                u.setAddress(newInformation[2]);
            }
        }
        saveUserList();
    }

    public boolean checkDuplicateEmail(String email) {
        for (User user : users) {
            if (user.getEmail() == null) {
                continue;
            }
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
