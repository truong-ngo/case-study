package printer;

public class ErrorPrinter {
    public void reChoice() {
        System.out.println("⛔ Invalid choice, please re-select.");
    }

    public void idDoesntExist() {
        System.out.println("⛔ Id doesn't exist");
    }

    public void noMatchProduct() {
        System.out.println("⛔ No match product");
    }

    public void invalidData() {
        System.out.println("⛔ Invalid data");
    }

    public void invalidId() {
        System.out.println("⛔ Invalid id");
    }

    public void updateEmailFail() {
        System.out.println("⛔ Invalid email");
    }

    public void updatePhoneNumberFail() {
        System.out.println("⛔ Invalid phone number");
    }

    public void loginFail() {
        System.out.println("⛔ Wrong username or password.");
    }

    public void fillUsernameAndPassword() {
        System.out.println("⛔ Please fill username and password field.");
    }

    public void userNameExist() {
        System.out.println("⛔ Username already exist");
    }

    public void userNotFound() {
        System.out.println("⛔ User not found");
    }

    public void emailNotFound() {
        System.out.println("⛔ Email not found");
    }


    public void duplicateEmail() {
        System.out.println("⛔ Email already exist");
    }

    public void duplicatePhoneNumber() {
        System.out.println("⛔ Phone number already exist");
    }

    public void addToCartFail() {
        System.out.println("⛔ Id doesnt exist or quantity exceed");
    }
}

