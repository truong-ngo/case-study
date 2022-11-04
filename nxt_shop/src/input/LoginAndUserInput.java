package input;

import menu.Resource;
import user.User;

import java.util.List;
import java.util.Scanner;

public class LoginAndUserInput {
    public String[] logInInput(Scanner scanner) {
        System.out.println("⌨ Username:");
        String userName = scanner.nextLine();
        System.out.println("⌨ Password:");
        String password = scanner.nextLine();
        return new String[]{userName, password};
    }

    public boolean validateUser(String[] data, List<User> users) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())
                && user.getRole().equals("USER")) {
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

    public boolean validateAdmin(String[] data, List<User> users) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())
                    && user.getRole().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public String changePassword(Scanner scanner) {
        System.out.println("⌨ Enter password:");
        return scanner.nextLine();
    }

    public String updateEmail(Scanner scanner) {
        System.out.println("⌨ Update email:");
        return scanner.nextLine();
    }

    public String updatePhoneNumber(Scanner scanner) {
        System.out.println("⌨ Update phone number:");
        return scanner.nextLine();
    }

    public String forgotPassword(Scanner scanner) {
        System.out.println("⌨ Enter email:");
        return scanner.nextLine();
    }

    public boolean checkDuplicateEmail(String email, List<User> users) {
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

    public boolean checkDuplicatePhoneNumber(String phoneNumber, List<User> users) {
        for (User user : users) {
            if (user.getPhoneNumber() == null) {
                continue;
            }
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
