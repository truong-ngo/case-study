package manager;

import io_file.IOFile;
import user.User;

import java.io.Serializable;
import java.util.List;

public class UserManager implements ManagerList<User> {
    private final List<User> users;
    private final User ADMIN = new User("admin","123456");
    private final String path = "src/file/users";
    private IOFile<User> ioFile;

    public UserManager() {
        ioFile = new IOFile<>();
        users = ioFile.readFile(path);
        if (users.isEmpty()) {
            ADMIN.setRole("ADMIN");
            users.add(ADMIN);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public IOFile<User> getIoFile() {
        return ioFile;
    }

    public String getPath() {
        return path;
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

    public User getADMIN() {
        return ADMIN;
    }

    public void saveUserList() {
        ioFile.writeToFile(users, path);
    }

    @Override
    public void add(User user) {
        users.add(user);
        ioFile.writeToFile(users, path);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
