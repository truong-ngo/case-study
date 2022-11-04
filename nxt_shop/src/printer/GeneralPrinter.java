package printer;

public class GeneralPrinter {
    public final MainMenuPrinter mainMenuPrinter;
    public final LoginMenuPrinter loginMenuPrinter;
    public final AdminMenuPrinter adminMenuPrinter;
    public final UserMenuPrinter userMenuPrinter;
    public final ProductManagerPrinter productManagerPrinter;
    public final UserManagerPrinter userManagerPrinter;
    public final CartManagerPrinter cartManagerPrinter;


    public GeneralPrinter() {
        mainMenuPrinter = new MainMenuPrinter();
        loginMenuPrinter = new LoginMenuPrinter();
        adminMenuPrinter = new AdminMenuPrinter();
        userMenuPrinter = new UserMenuPrinter();
        productManagerPrinter = new ProductManagerPrinter();
        userManagerPrinter = new UserManagerPrinter();
        cartManagerPrinter = new CartManagerPrinter();
    }

    public void reChoice() {
        System.out.println("⛔ Invalid choice, please re-select.");
    }

}
