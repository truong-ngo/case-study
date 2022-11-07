package menu;

import input.Input;
import printer.Printer;

public abstract class AbstractMenu {
    public Printer printer;
    public Input input;

    public AbstractMenu() {
        printer = new Printer();
        input = new Input();
    }
}
