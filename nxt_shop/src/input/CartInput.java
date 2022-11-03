package input;

import java.util.Scanner;

public class CartInput {
    public String[] addToCartInput(Scanner scanner) {
        System.out.println("Enter id of Product:");
        String id = scanner.nextLine();
        System.out.println("Enter quantity to add: ");
        String quantity = scanner.nextLine();
        return new String[]{id,quantity};
    }
}
