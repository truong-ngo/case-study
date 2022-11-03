package menu;

import input.GeneralInput;
import manager.GeneralManager;
import printer.GeneralPrinter;

public class Resource {
    public GeneralPrinter printer;
    public GeneralInput input;
    public GeneralManager manager;

    public Resource() {
        printer = new GeneralPrinter();
        input = new GeneralInput();
        manager = new GeneralManager();
    }
}
