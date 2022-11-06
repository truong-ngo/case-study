package menu;

import input.GeneralInput;
import printer.GeneralPrinter;

public abstract class AbstractMenu {
    public GeneralPrinter printer;
    public GeneralInput input;

    public AbstractMenu() {
        printer = new GeneralPrinter();
        input = new GeneralInput();
    }
}
