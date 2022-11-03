package printer;

public class GeneralPrinter {
    public final MainMenuPrinter menuPrinter;
    public final LoginMenuPrinter loginMenuPrinter;
    public final ProductManagerPrinter productManagerPrinter;
    public final UserManagerPrinter userManagerPrinter;
    public final UserMenuPrinter userMenuPrinter;

    public GeneralPrinter() {
        menuPrinter = new MainMenuPrinter();
        loginMenuPrinter = new LoginMenuPrinter();
        productManagerPrinter = new ProductManagerPrinter();
        userManagerPrinter = new UserManagerPrinter();
        userMenuPrinter = new UserMenuPrinter();
    }

    public void reChoice() {
        System.out.println("⛔ Wrong input, please re-choice.");
    }

}
