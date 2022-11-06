package printer;

public class ErrorPrinter {
    public void itemNotFound(String item) {
        System.out.println("⛔ " + item + " not found");
    }

    public void itemAlreadyExist(String item) {
        System.out.println("⛔ " + item + " already exist");
    }

    public void itemDoesntExist(String item) {
        System.out.println("⛔ " + item + " doesn't exist");
    }

    public void pleaseEnterAllData() {
        System.out.println("⛔ Please enter all data");
    }
    public void reChoice() {
        System.out.println("⛔ Invalid choice, please re-select.");
    }

    public void idDoesntExist() {
        System.out.println("⛔ Id doesn't exist");
    }

    public void noMatchFound() {
        System.out.println("⛔ No match found");
    }

    public void invalidData(String data) {
        System.out.println("⛔ Invalid " + data);
    }

    public void invalidId() {
        System.out.println("⛔ Invalid id");
    }

    public void loginFail() {
        System.out.println("⛔ Wrong username or password.");
    }

    public void addToCartFail() {
        System.out.println("⛔ Id doesnt exist or quantity exceed");
    }
}

