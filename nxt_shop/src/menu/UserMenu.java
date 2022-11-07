package menu;

import manager.Manager;
import product.Product;
import shop_item.UserBills;
import shop_item.UserCart;
import shop_item.User;

import java.time.LocalDateTime;
import java.util.*;

public class UserMenu extends AbstractMenu {
    public void run(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printUserPage(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 5)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    manager.product.displayAll(printer);
                    runAddToCart(scanner, manager, user);
                    break;
                case 2:
                    runSearch(scanner, manager, user);
                    break;
                case 3:
                    manager.getProduct().displayByPrice(printer);
                    runAddToCart(scanner, manager, user);
                    break;
                case 4:
                    runCartManager(scanner, manager, user);
                    break;
                case 5:
                    runAccountManager(manager, scanner, user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    private void runSearch(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printSearch();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String name = input.product.inputStringData(scanner, printer, "name");
                    if (manager.product.searchByName(name, printer)) {
                        runAddToCart(scanner, manager, user);
                    }
                    break;
                case 2:
                    String brand = input.product.inputStringData(scanner, printer, "brand");
                    if (manager.product.searchByBrand(brand, printer)) {
                        runAddToCart(scanner, manager, user);
                    }
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAddToCart(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            UserCart userCart = manager.cart.getCartByUser(user);
            printer.menu.printViewProduct(user);
            String string = scanner.nextLine();
            int choice = -1;
            if (input.validate.validateChoice(string, 0, 1)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    addToCartChoice(scanner, manager, userCart);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void addToCartChoice(Scanner scanner, Manager manager, UserCart userCart) {
        int[] addInput = input.cart.addToCartInput(scanner, printer, input);
        if (addInput != null) {
            int id = addInput[0], quantity = addInput[1];
            if (manager.product.checkId(id)) {
                Product product = manager.product.getProductById(id);
                if (quantity <= product.getQuantity()) {
                    printer.error.exceedAmount("quantity");
                } else {
                    userCart.addToCart(product, addInput[1]);
                    manager.cart.saveUserCartList();
                    printer.success.addToCartSuccessfully();
                }
            } else if (!manager.product.checkId(id)) {
                printer.error.itemDoesntExist("ID");
            }
        } else {
            printer.error.reChoice();
        }
    }

    public void runCartManager(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        UserCart userCart = manager.cart.getCartByUser(user);
        Map<Product, Integer> cartItem = userCart.getCart();
        UserBills userBills = manager.bill.getUserBillsByUser(user);
        while (check) {
            int choice = -1;
            printer.menu.printCartManager(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 4)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    printer.table.printCart(cartItem, user, "cart");
                    break;
                case 2:
                    if (cartItem.isEmpty()) {
                        printer.notification.cartIsEmpty();
                    } else {
                        cartItem.clear();
                        manager.cart.saveUserCartList();
                        printer.success.cartClearSuccessfully();
                    }
                    break;
                case 3:
                    if (cartItem.isEmpty()) {
                        printer.notification.cartIsEmpty();
                    } else {
                        if (userCart.getCartAmount() > user.getBalance()) {
                            printer.notification.notEnoughBalance();
                        } else {
                            int newBalance = user.getBalance() - userCart.getCartAmount();
                            user.setBalance(newBalance);
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
                            manager.user.saveUserList();
                            manager.product.saveProductList();
                            manager.cart.saveUserCartList();
                            manager.bill.saveUserBillsList();
                            printer.success.paymentSuccessfully();
                        }
                    }
                    break;
                case 4:
                    printer.table.printBill(userBills, user, "bill");
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runAccountManager(Manager manager, Scanner scanner, User user) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printAccountManager(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 4)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.reChoice();
            }
            switch (choice) {
                case 1:
                    String newPassword = input.user.inputItem(scanner, printer, "new password");
                    if (user.getPassword().equals(newPassword) || newPassword.equals("")) {
                        printer.notification.itemNotChanged("Password");
                    } else {
                        user.setPassword(newPassword);
                        manager.user.saveUserList();
                        printer.success.actionSuccessfully("Change password");
                    }
                    break;
                case 2:
                    String[] newInformation = input.user.userInformationInput(scanner, printer, input);
                    if (newInformation == null) {
                        printer.notification.itemHasNotBeenUpdated("User information");
                    } else if (newInformation.length == 0) {
                        printer.error.invalidData("information");
                    } else if (newInformation.length == 2) {
                        manager.user.update(newInformation, user);
                        printer.success.actionSuccessfully("User information update");
                    }
                    break;
                case 3:
                    int amount = input.product.getNumberData(scanner, printer, input, "amount of money");
                    int balance = user.getBalance();
                    user.setBalance(balance + amount);
                    manager.user.saveUserList();
                    printer.success.addSuccessfully();
                    break;
                case 4:
                    printer.table.printUserInformation(user);
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
