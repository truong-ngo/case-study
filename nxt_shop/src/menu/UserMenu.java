package menu;

import manager.Manager;
import product.Product;
import shop_item.*;

import java.time.LocalDateTime;
import java.util.*;

public class UserMenu extends AbstractMenu {
    public void run(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            int choice = -1;
            printer.menu.printUserPage(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 6)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
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
                    manager.product.displayByPrice(printer);
                    runAddToCart(scanner, manager, user);
                    break;
                case 4:
                    runCartManager(scanner, manager, user);
                    break;
                case 5:
                    runAccountManager(manager, scanner, user);
                    break;
                case 6:
                    runChatSession(scanner, manager, user);
                    break;
                case 0:
                    check = false;
            }
        }
    }

    private void runSearch(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            int choice = -2;
            printer.menu.printSearch();
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
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
            Cart userCart = manager.cart.getCartByUser(user);
            printer.menu.printViewProduct(user);
            String string = scanner.nextLine();
            int choice = -1;
            if (input.validate.validateChoice(string, 0, 1)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
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

    public void addToCartChoice(Scanner scanner, Manager manager, Cart userCart) {
        int[] addInput = input.cart.addToCartInput(scanner, printer, input);
        if (addInput == null) {
            printer.error.pleaseEnterData("ID or quantity");
        } else if (addInput.length == 0) {
            printer.error.pleaseEnterData("ID and quantity");
        } else if (addInput.length == 2) {
            int id = addInput[0], quantity = addInput[1];
            if (manager.product.checkId(id)) {
                Product product = manager.product.getProductById(id);
                if (quantity > product.getQuantity()) {
                    printer.error.exceedAmount("Quantity");
                } else {
                    userCart.addToCart(product, addInput[1]);
                    manager.cart.saveCartList();
                    printer.success.actionSuccessfully("Add to card");
                }
            } else if (!manager.product.checkId(id)) {
                printer.error.itemNotFound("ID");
            }
        }
    }

    public void runCartManager(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        Cart userCart = manager.cart.getCartByUser(user);
        Map<Product, Integer> cartItem = userCart.getCart();
        UserBills userBills = manager.bill.getUserBillsByUser(user);
        while (check) {
            int choice = -1;
            printer.menu.printCartManager(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 4)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    printer.table.printCart(cartItem, user, "cart");
                    break;
                case 2:
                    if (cartItem.isEmpty()) {
                        printer.notification.itemIsEmpty("Cart");
                    } else {
                        cartItem.clear();
                        manager.cart.saveCartList();
                        printer.success.actionSuccessfully("Cart clear");
                    }
                    break;
                case 3:
                    if (cartItem.isEmpty()) {
                        printer.notification.itemIsEmpty("Cart");
                    } else {
                        if (userCart.getCartAmount() > user.getBalance()) {
                            printer.notification.notEnoughBalance();
                        } else {
                            String address = user.getAddress();
                            boolean checkAddress = true;
                            if (address == null) {
                                printer.inputBox.printInputBox("address");
                                address = scanner.nextLine();
                                if (address.equals("")) {
                                    checkAddress = false;
                                    printer.error.pleaseEnterData("email");
                                }
                            }
                            if (checkAddress) {
                                user.setAddress(address);
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
                                ShipSession shipSession = new ShipSession(user, bill);
                                Thread thread = new Thread(shipSession);
                                thread.start();
                                cartItem.clear();
                                manager.user.saveUserList();
                                manager.product.saveProductList();
                                manager.cart.saveCartList();
                                manager.bill.saveBillsList();
                                printer.success.actionSuccessfully("Payment");
                                printer.table.printBill(billItem, user, "bill", time);
                            }
                        }
                    }
                    break;
                case 4:
                    printer.table.printListBills(userBills, user, "list bills");
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
            if (input.validate.validateChoice(string, 0, 5)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    String newPassword = input.user.inputItem(scanner, printer, "new password");
                    if (newPassword != null) {
                        if (user.getPassword().equals(newPassword) || newPassword.equals("")) {
                            printer.notification.itemHasNotBeenUpdated("Password");
                        } else {
                            user.setPassword(newPassword);
                            manager.user.saveUserList();
                            printer.success.actionSuccessfully("Change password");
                        }
                    } else {
                        printer.error.pleaseEnterData("new password");
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
                    int amount;
                    String amountString = input.product.inputStringData(scanner, printer, "amount of money");
                    if (amountString.equals("")) {
                        printer.error.pleaseEnterData("amount of money");
                    } else if (input.validate.validateNumber(amountString)) {
                        amount = Integer.parseInt(amountString);
                        if (amount == 0) {
                            printer.notification.itemHasNotBeenUpdated("Your balance");
                        } else {
                            int balance = user.getBalance();
                            user.setBalance(balance + amount);
                            manager.user.saveUserList();
                            printer.success.actionSuccessfully("Add");
                        }
                    } else {
                        printer.error.invalidData("amount");
                    }
                    break;
                case 4:
                    printer.table.printUserInformation(user);
                    break;
                case 5:
                    printer.table.printNotification(user);
                    manager.user.saveUserList();
                    break;
                case 0:
                    check = false;
            }
        }
    }

    public void runChatSession(Scanner scanner, Manager manager, User user) {
        boolean check = true;
        while (check) {
            User admin = manager.user.getAdmin();
            ChatSession chatSession = manager.chat.getSessionByUsers(user, admin);
            printer.table.printChatBox(user, admin, chatSession);
            int choice = -1;
            printer.menu.printChat(user);
            String string = scanner.nextLine();
            if (input.validate.validateChoice(string, 0, 2)) {
                choice = Integer.parseInt(string);
            } else {
                printer.error.invalidData("choice");
            }
            switch (choice) {
                case 1:
                    manager.chat.runChatSession(scanner, printer, input, user, admin, chatSession);
                    manager.chat.saveSessionList();
                    break;
                case 2:
                    manager.chat.readSessionList();
                    break;
                case 0:
                    check = false;
            }
        }
    }
}
