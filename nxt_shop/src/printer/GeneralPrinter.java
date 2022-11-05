package printer;

public class GeneralPrinter {

    public final MenuPrinter menu;
    public final TablePrinter table;
    public final ErrorPrinter error;
    public final SuccessPrinter success;
    public final NotificationPrinter notification;

    public GeneralPrinter() {
        menu = new MenuPrinter();
        table = new TablePrinter();
        error = new ErrorPrinter();
        success = new SuccessPrinter();
        notification = new NotificationPrinter();
    }
}
