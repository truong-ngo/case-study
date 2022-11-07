package menu;

import input.Input;
import printer.GeneralPrinter;

public abstract class AbstractMenu {
    public GeneralPrinter printer;
    public Input input;

    public AbstractMenu() {
        printer = new GeneralPrinter();
        input = new Input();
    }
}
