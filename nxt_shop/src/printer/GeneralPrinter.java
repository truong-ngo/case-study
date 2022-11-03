package printer;

public class GeneralPrinter {
    public final MainMenuPrinter menuPrinter;
    public final LoginMenuPrinter loginMenuPrinter;
    public final ProductManagerPrinter productManagerPrinter;
    public final UserManagerPrinter userManagerPrinter;
    public final UserMenuPrinter userMenuPrinter;
    public final CartManagerPrinter cartManagerPrinter;

    public GeneralPrinter() {
        menuPrinter = new MainMenuPrinter();
        loginMenuPrinter = new LoginMenuPrinter();
        productManagerPrinter = new ProductManagerPrinter();
        userManagerPrinter = new UserManagerPrinter();
        userMenuPrinter = new UserMenuPrinter();
        cartManagerPrinter = new CartManagerPrinter();
    }

    public void reChoice() {
        System.out.println("⛔ Invalid choice, please re-select.");
    }

}
