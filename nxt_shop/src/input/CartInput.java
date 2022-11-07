package input;

import printer.Printer;

import java.util.Scanner;

public class CartInput {
    public int[] addToCartInput(Scanner scanner, Printer printer, Input input) {
        printer.inputBox.printInputBox("ID of product");
        String id = scanner.nextLine();
        printer.inputBox.printInputBox("quantity to add");
        String quantity = scanner.nextLine();
        if (id.equals("") && quantity.equals("")) {
            return new int[0];
        } else if (input.validate.validateNumber(id) && input.validate.validateNumber(quantity)) {
            return new int[]{Integer.parseInt(id),Integer.parseInt(quantity)};
        } else {
            return null;
        }
    }
}
