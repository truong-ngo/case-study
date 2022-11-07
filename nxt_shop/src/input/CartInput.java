package input;

import printer.GeneralPrinter;

import java.util.Scanner;

public class CartInput {
    public int[] addToCartInput(Scanner scanner, GeneralPrinter printer, Input input) {
        printer.inputBox.printInputBox("ID of product");
        String id = scanner.nextLine();
        printer.inputBox.printInputBox("quantity to add");
        String quantity = scanner.nextLine();
        if (input.validate.validateNumber(id) && input.validate.validateNumber(quantity)) {
            return new int[]{Integer.parseInt(id),Integer.parseInt(quantity)};
        } else {
            printer.error.invalidData("ID or quantity");
            return null;
        }

    }
}
