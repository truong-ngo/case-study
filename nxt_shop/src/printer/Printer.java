package printer;

public class Printer {
    public final MenuPrinter menu;
    public final TablePrinter table;
    public final ErrorPrinter error;
    public final SuccessPrinter success;
    public final NotificationPrinter notification;
    public final InputBoxPrinter inputBox;

    public Printer() {
        menu = new MenuPrinter();
        table = new TablePrinter();
        error = new ErrorPrinter();
        success = new SuccessPrinter();
        notification = new NotificationPrinter();
        inputBox = new InputBoxPrinter();
    }
}
