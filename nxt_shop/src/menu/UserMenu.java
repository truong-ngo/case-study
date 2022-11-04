package menu;

import product.Product;
import shop_item.Cart;
import shop_item.User;

import java.time.LocalDateTime;
import java.util.*;

public class UserMenu {
    public void runSearchMenu(Scanner scanner, Resource resource) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.userMenuPrinter.searchPrinter();
            String string = scanner.nextLine();
            if (resource.input.validate.validateSearchChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = resource.input.productInput.inputStringData(scanner, "name");
                    if (!name.equals("")) {
                        resource.manager.getProductManager().searchByName(name, resource);
                    } else {
                        resource.printer.productManagerPrinter.invalidName();
                    }
                    break;
                case 2:
                    String brand = resource.input.productInput.inputStringData(scanner, "brand");
                    if (!brand.equals("")) {
                        resource.manager.getProductManager().searchByBrand(brand, resource);
                    } else {
                        resource.printer.productManagerPrinter.invalidBrand();
                    }
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
            resource.printer.mainMenuPrinter.printUserPage(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateCartChoice(string)) {
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
                        if (resource.input.validate.validateSearchChoice(str)) {
                            searchChoice = Integer.parseInt(str);
                        } else {
                            resource.printer.reChoice();
                        }
                        switch (searchChoice) {
                            case 1:
                                String name = resource.input.productInput.inputStringData(scanner, "name");
                                if (resource.manager.getProductManager().searchByName(name, resource)) {
                                    runAddToCartMenu(scanner, resource, user, cart);
                                }
                                break;
                            case 2:
                                String brand = resource.input.productInput.inputStringData(scanner, "brand");
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
                    runAccountManager(resource, scanner, user);
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
            if (resource.input.validate.validateAddToCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] strings = resource.input.cartInput.addToCartInput(scanner);
                    if (resource.input.validate.validateIdInput(strings[0]) &&
                        resource.input.validate.validateInputNumberData(strings[1])) {
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
        Map<Map<Product, Integer>, LocalDateTime> billItem = cart.getBill();
        int choice = -1;
        while (check) {
            resource.printer.userMenuPrinter.printCartManager(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateInputNumberData(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.printer.cartManagerPrinter.printCart(cartItem, user, "cart");
                    break;
                case 2:
                    if (cartItem.isEmpty()) {
                        resource.printer.cartManagerPrinter.cartIsEmpty();
                    } else {
                        cartItem.clear();
                        resource.manager.getCartManager().saveCartList();
                        resource.printer.cartManagerPrinter.cartClearSuccessfully();
                    }
                    break;
                case 3:
                    if (cartItem.isEmpty()) {
                        resource.printer.cartManagerPrinter.cartIsEmpty();
                    } else {
                        LocalDateTime time = LocalDateTime.now();
                        Map<Product, Integer> bill = new HashMap<>(cartItem);
                        billItem.put(bill, time);
                        Set<Product> products = cartItem.keySet();
                        for (Product product : products) {
                            int quantity = product.getQuantity() - cartItem.get(product);
                            product.setQuantity(quantity);
                        }
                        cartItem.clear();
                        resource.manager.getCartManager().saveCartList();
                        resource.manager.getProductManager().saveProductList();
                        resource.printer.cartManagerPrinter.paymentSuccessfully();
                    }
                    break;
                case 4:
                    resource.printer.cartManagerPrinter.printBill(billItem, user, "bill");
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAccountManager(Resource resource, Scanner scanner, User user) {
        boolean check = true;
        int choice = -1;
        while (check) {
            resource.printer.userMenuPrinter.printAccountManager(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateAccountManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String newPassword = resource.input.loginAndUserInput.changePassword(scanner);
                    if (user.getPassword().equals(newPassword) || newPassword.equals("")) {
                        resource.printer.loginMenuPrinter.passWordNotChanged();
                    } else {
                        user.setPassword(newPassword);
                        resource.manager.getUserManager().saveUserList();
                        resource.printer.loginMenuPrinter.passWordChanged();
                    }
                    break;
                case 2:
                    runAccountUpdateMenu(resource, scanner, user);
                    break;
                case 3:
                    resource.printer.userMenuPrinter.printUserInformation(user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAccountUpdateMenu(Resource resource, Scanner scanner, User user) {
        boolean check = true;
        int choice = -1;
        List<User> users = resource.manager.getUserManager().getUsers();
        while (check) {
            resource.printer.userMenuPrinter.printAccountUpdate(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateAccountUpdateChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.reChoice();
            }
            switch (choice) {
                case 1:
                    String newEmail = resource.input.loginAndUserInput.updateEmail(scanner);
                    if (resource.input.validate.validateEmail(newEmail)) {
                        if (!resource.input.loginAndUserInput.checkDuplicateEmail(newEmail, users)) {
                            user.setEmail(newEmail);
                            resource.manager.getUserManager().saveUserList();
                            resource.printer.userMenuPrinter.updateSuccessfully();
                        } else {
                            resource.printer.loginMenuPrinter.duplicateEmail();
                        }
                    } else {
                        resource.printer.userMenuPrinter.updateFail();
                    }
                    break;
                case 2:
                    String newPhoneNumber = resource.input.loginAndUserInput.updatePhoneNumber(scanner);
                    if (resource.input.validate.validatePhoneNumber(newPhoneNumber)) {
                        if (!resource.input.loginAndUserInput.checkDuplicatePhoneNumber(newPhoneNumber, users)) {
                            user.setPhoneNumber(newPhoneNumber);
                            resource.manager.getUserManager().saveUserList();
                            resource.printer.userMenuPrinter.updateSuccessfully();
                        } else {
                            resource.printer.loginMenuPrinter.duplicatePhoneNumber();
                        }
                    } else {
                        resource.printer.userMenuPrinter.updateFail();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
