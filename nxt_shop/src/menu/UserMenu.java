package menu;

import product.Product;
import shop_item.UserBills;
import shop_item.UserCart;
import shop_item.User;

import java.time.LocalDateTime;
import java.util.*;

public class UserMenu {
    public void runUserMenu(Scanner scanner, Resource resource, User user) {
        UserCart userCart = resource.manager.cart.getCartByUser(user);
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menu.printUserPageMenu(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.manager.product.displayAll(resource);
                    runAddToCartMenu(scanner, resource, user, userCart);
                    break;
                case 2:
                    runUserSearchMenu(scanner, resource, user, userCart);
                    break;
                case 3:
                    resource.manager.getProduct().displayByPrice(resource);
                    runAddToCartMenu(scanner, resource, user, userCart);
                    break;
                case 4:
                    runCartManager(scanner, resource, user, userCart);
                    break;
                case 5:
                    runAccountManager(resource, scanner, user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    private void runUserSearchMenu(Scanner scanner, Resource resource, User user, UserCart userCart) {
        boolean check = true;
        while (check) {
            int choice = -1;
            resource.printer.menu.printSearchMenu();
            String string = scanner.nextLine();
            if (resource.input.validate.validateSearchChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = resource.input.productInput.inputStringData(scanner, "name");
                    if (resource.manager.product.searchByName(name, resource)) {
                        runAddToCartMenu(scanner, resource, user, userCart);
                    }
                    break;
                case 2:
                    String brand = resource.input.productInput.inputStringData(scanner, "brand");
                    if (resource.manager.product.searchByBrand(brand, resource)) {
                        runAddToCartMenu(scanner, resource, user, userCart);
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddToCartMenu(Scanner scanner, Resource resource, User user,
                                 UserCart cart) {
        boolean check = true;
        while (check) {
            resource.printer.menu.printViewProductMenu(user);
            String string = scanner.nextLine();
            int choice = -1;
            if (resource.input.validate.validateAddToCartChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String[] strings = resource.input.cartInput.addToCartInput(scanner);
                    if (resource.input.validate.validateIdInput(strings[0]) &&
                        resource.input.validate.validateInputNumberData(strings[1])) {
                        int id = Integer.parseInt(strings[0]);
                        Product product = resource.manager.product.getProductById(id);
                        int quantity = Integer.parseInt(strings[1]);
                        if (resource.manager.product.checkId(id)
                            && quantity <= product.getQuantity()) {
                            cart.addToCart(product, quantity);
                            resource.manager.cart.saveUserCartList();
                            resource.printer.success.addToCartSuccessfully();
                        } else {
                            resource.printer.error.addToCartFail();
                        }
                    } else {
                        resource.printer.error.reChoice();
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runCartManager(Scanner scanner, Resource resource, User user, UserCart cart) {
        boolean check = true;
        Map<Product, Integer> cartItem = cart.getCart();
        UserBills userBills = resource.manager.bill.getUserBillsByUser(user);
        int choice = -1;
        while (check) {
            resource.printer.menu.printCartManager(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateCartManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    resource.printer.table.printCart(cartItem, user, "cart");
                    break;
                case 2:
                    if (cartItem.isEmpty()) {
                        resource.printer.notification.cartIsEmpty();
                    } else {
                        cartItem.clear();
                        resource.manager.cart.saveUserCartList();
                        resource.printer.success.cartClearSuccessfully();
                    }
                    break;
                case 3:
                    if (cartItem.isEmpty()) {
                        resource.printer.notification.cartIsEmpty();
                    } else {
                        LocalDateTime time = LocalDateTime.now();
                        Map<Product, Integer> billItem = new TreeMap<>(cartItem);
                        UserBills.Bill bill = userBills.new Bill();
                        bill.add(billItem, time);
                        userBills.addBill(bill);
                        Set<Product> products = cartItem.keySet();
                        for (Product product : products) {
                            int quantity = product.getQuantity() - cartItem.get(product);
                            product.setQuantity(quantity);
                        }
                        cartItem.clear();
                        resource.manager.product.saveProductList();
                        resource.manager.cart.saveUserCartList();
                        resource.manager.bill.saveUserBillsList();
                        resource.printer.success.paymentSuccessfully();
                    }
                    break;
                case 4:
                    resource.printer.table.printBill(userBills, user, "bill");
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
            resource.printer.menu.printAccountManagerMenu(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateAccountManagerChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String newPassword = resource.input.loginAndUserInput.changePassword(scanner);
                    if (user.getPassword().equals(newPassword) || newPassword.equals("")) {
                        resource.printer.notification.passWordNotChanged();
                    } else {
                        user.setPassword(newPassword);
                        resource.manager.user.saveUserList();
                        resource.printer.success.passWordChanged();
                    }
                    break;
                case 2:
                    runAccountUpdateMenu(resource, scanner, user);
                    break;
                case 3:
                    resource.printer.table.printUserInformation(user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAccountUpdateMenu(Resource resource, Scanner scanner, User user) {
        boolean check = true;
        int choice = -1;
        List<User> users = resource.manager.user.getUsers();
        while (check) {
            resource.printer.menu.printAccountUpdateMenu(user);
            String string = scanner.nextLine();
            if (resource.input.validate.validateAccountUpdateChoice(string)) {
                choice = Integer.parseInt(string);
            } else {
                resource.printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String newEmail = resource.input.loginAndUserInput.updateEmail(scanner);
                    if (newEmail.equals("")) {
                        resource.printer.notification.pleaseFillEmail();
                    } else {
                        if (resource.input.validate.validateEmail(newEmail)) {
                            if (!resource.input.loginAndUserInput.checkDuplicateEmail(newEmail, users)) {
                                user.setEmail(newEmail);
                                resource.manager.user.saveUserList();
                                resource.printer.success.updateSuccessfully();
                            } else {
                                resource.printer.error.duplicateEmail();
                            }
                        } else {
                            resource.printer.error.updateEmailFail();
                        }
                    }
                    break;
                case 2:
                    String newPhoneNumber = resource.input.loginAndUserInput.updatePhoneNumber(scanner);
                    if (newPhoneNumber.equals("")) {
                        resource.printer.notification.pleaseFillPhoneNumber();
                    } else {
                        if (resource.input.validate.validatePhoneNumber(newPhoneNumber)) {
                            if (!resource.input.loginAndUserInput.checkDuplicatePhoneNumber(newPhoneNumber, users)) {
                                user.setPhoneNumber(newPhoneNumber);
                                resource.manager.user.saveUserList();
                                resource.printer.success.updateSuccessfully();
                            } else {
                                resource.printer.error.duplicatePhoneNumber();
                            }
                        } else {
                            resource.printer.error.updatePhoneNumberFail();
                        }
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
