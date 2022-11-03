package menu;

import product.Product;
import user.Cart;
import user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMenu {
    public void runSearchMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.userMenuPrinter.searchPrinter();
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateSearchChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = resource.input.productInput.inputName(scanner);
                    resource.manager.getProductManager().searchByName(name, resource);
                    break;
                case 2:
                    String brand = resource.input.productInput.inputBrand(scanner);
                    resource.manager.getProductManager().searchByBrand(brand, resource);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runUserMenu(Scanner scanner, Resource resource, User user) {
        Cart cart = resource.manager.getCartManager().getCartByUser(user);
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menuPrinter.printUserPage(user);
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.manager.getProductManager().displayAll(resource);
                    runAddToCartMenu(scanner, resource, user, cart);
                    break;
                case 2:
                    boolean searchCheck = true;
                    while (searchCheck) {
                        int searchChoice = -1;
                        resource.printer.userMenuPrinter.searchPrinter();
                        String str = scanner.nextLine();
                        if (resource.input.validateMenuChoice.validateSearchChoice(str)) {
                            searchChoice = Integer.parseInt(str);
                        } else {
                            resource.printer.reChoice();
                        }
                        switch (searchChoice) {
                            case 1:
                                String name = resource.input.productInput.inputName(scanner);
                                if (resource.manager.getProductManager().searchByName(name, resource)) {
                                    runAddToCartMenu(scanner, resource, user, cart);
                                }
                                break;
                            case 2:
                                String brand = resource.input.productInput.inputBrand(scanner);
                                if (resource.manager.getProductManager().searchByBrand(brand, resource)) {
                                    runAddToCartMenu(scanner, resource, user, cart);
                                }
                                break;
                            case 0:
                                searchCheck = false;
                        }
                    }
                    break;
                case 3:
                    resource.manager.getProductManager().displayByPrice(resource);
                    runAddToCartMenu(scanner, resource, user, cart);
                    break;
                case 4:
                    runCartManager(scanner, resource, user);
                    break;
                case 5:
                    // Account
                    System.out.println();
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddToCartMenu(Scanner scanner, Resource resource, User user,
                                 Cart cart) {
        boolean check = true;
        while (check) {
            resource.printer.userMenuPrinter.printViewProductMenu(user);
            String string = scanner.nextLine();
            int choice = -1;
            if (resource.input.validateMenuChoice.validateAddToCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] strings = resource.input.cartInput.addToCartInput(scanner);
                    if (resource.input.validateMenuChoice.validateIdInput(strings[0]) &&
                        resource.input.validateMenuChoice.validateQuantityInput(strings[1])) {
                        int id = Integer.parseInt(strings[0]);
                        Product product = resource.manager.getProductManager().getProductById(id);
                        int quantity = Integer.parseInt(strings[1]);
                        if (resource.manager.getProductManager().checkId(id)
                            && quantity <= product.getQuantity()) {
                            cart.addToCart(product, quantity);
                            resource.manager.getCartManager().saveCartList();
                            System.out.println("✅ Add to cart successfully");
                        } else {
                            System.out.println("⛔ Id doesnt exist or quantity exceed");
                        }
                    } else {
                        resource.printer.reChoice();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runCartManager(Scanner scanner, Resource resource, User user) {
        boolean check = true;
        Cart cart = resource.manager.getCartManager().getCartByUser(user);
        Map<Product, Integer> cartItem = cart.getCart();
        Map<Product, Integer> billItem = cart.getBill();
        int choice = -1;
        while (check) {
            resource.printer.userMenuPrinter.printCartManager(user);
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateCartManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.printer.cartManagerPrinter.printCart(cartItem, user, "cart");
                    break;
                case 2:
                    cartItem.clear();
                    resource.manager.getCartManager().saveCartList();
                    resource.printer.cartManagerPrinter.cartClearSuccessfully();
                    break;
                case 3:
                    if (cartItem.isEmpty()) {
                        resource.printer.cartManagerPrinter.cartIsEmpty();
                    } else {
                        billItem.putAll(cartItem);
                        cartItem.clear();
                        LocalDate date = LocalDate.now();
                        resource.manager.getCartManager().saveCartList();
                        resource.printer.cartManagerPrinter.paymentSuccessfully();
                    }
                    break;
                case 4:
                    resource.printer.cartManagerPrinter.printCart(billItem, user, "bill");
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void printAccountManager(Resource resource, Scanner scanner, User user) {
        boolean check = true;
        int choice = -1;
        while (check) {
            resource.printer.userMenuPrinter.printAccountManager(user);
            String string = scanner.nextLine();
            if (resource.input.validateMenuChoice.validateAccountManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String newPassword = resource.input.loginInput.changePasswordInput(scanner);
                    if (user.getPassword().equals(newPassword)) {
                        resource.printer.loginMenuPrinter.passWordNotChanged();
                    } else {
                        user.setPassword(newPassword);
                        resource.printer.loginMenuPrinter.passWordChanged();
                    }
                    break;
                case 2:
                    // Update information;
                case 0:
                    check = false;
            }
        }

    }
}
