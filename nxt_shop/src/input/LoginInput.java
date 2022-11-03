package input;

import menu.Resource;
import user.User;

import java.util.List;
import java.util.Scanner;

public class LoginInput {
    public String[] logInInput(Scanner scanner) {
        System.out.println("▶ Username:");
        String userName = scanner.nextLine();
        System.out.println("▶ Password:");
        String password = scanner.nextLine();
        return new String[]{userName, password};
    }

    public boolean validateUser(String[] data, List<User> users) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistUserName(String name, Resource resource) {
        List<User> users = resource.manager.getUserManager().getUsers();
        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAdmin(String[] data, User admin) {
        if (data[0].equals(admin.getUserName()) && data[1].equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public String changePasswordInput(Scanner scanner) {
        System.out.println("▶ Enter Password:");
        return scanner.nextLine();
    }
}
