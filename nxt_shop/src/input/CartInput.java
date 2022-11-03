package input;

import java.util.Scanner;

public class CartInput {
    public String addToCartInput(Scanner scanner) {
        System.out.println("Enter id of Product to add:");
        return scanner.nextLine();
    }
}
