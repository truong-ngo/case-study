package printer;

import product.Product;
import shop_item.ChatSession;
import shop_item.Messenger;
import shop_item.User;
import shop_item.UserBills;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TablePrinter {
    public void printUserList(List<User> users) {
        String header = "│ %-3s │ %-15s │ %-25s │ %-15s │ %-45s │\n";
        String content = "│ %-3d │ %-15s │ %-25s │ %-15s │ %-45s │\n";
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "No", "Username", "Email", "Phone number", "Address");
        int i = 1;
        for (User user : users) {
            if (user.getRole().equals("ADMIN")) {
                continue;
            }
            String email = (user.getEmail() == null ) ? "" : user.getEmail();
            String address = (user.getAddress() == null ) ? "" : user.getAddress();
            String phoneNUmber = (user.getPhoneNumber() == null ) ? "" : user.getPhoneNumber();
            System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.printf(content, i, user.getUsername(), email, phoneNUmber, address);
            i++;
        }
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public void printCart(Map<Product, Integer> cart, User user, String type) {
        Set<Product> products = cart.keySet();
        int sum = 0;
        String header = "│ %2s │ %-15s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-15s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        System.out.println("\uD83D\uDED2 " + user.getUsername() + " " + type);
        printTable(header, content, footer, cart, sum, products);
    }

    public void printBill(UserBills.Bill bill, User user, String type, LocalDateTime time) {
        Map<Product, Integer> billItem = bill.getListItem();
        Set<Product> products = billItem.keySet();
        int sum = 0;
        String header = "│ %2s │ %-20s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-20s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-46s │ %10d │\n";
        System.out.println("\uD83D\uDCCB " + user.getUsername() + " " + type + " ID: " + bill.getBillNo() + " at " + time.toString());
        printTable(header, content, footer, billItem, sum, products);
    }

    public void printListBills(UserBills userBills, User user, String type) {
        List<UserBills.Bill> bills = userBills.getBills();
        System.out.println("\uD83E\uDDFE " + user.getUsername() + " " + type + ":");
        String header = "│ %2s │ %-20s │ %10s │ %10s │ %10s │\n";
        String content = "│ %-2d │ %-20s │ %10d │ %10d │ %10d │\n";
        String footer = "│ %-51s │ %10d │\n";
        int total = 0;
        for (UserBills.Bill bill : bills) {
            int sum = 0;
            Map<Product, Integer> billItem = bill.getListItem();
            Set<Product> products = billItem.keySet();
            System.out.println("\uD83D\uDCCB Bill " + bill.getBillNo() + " at " + bill.getPaymentTime());
            sum = printTable(header, content, footer, billItem, sum, products);
            total += sum;
        }
        System.out.println("\uD83D\uDCB5 Total spent of user " + user.getUsername() + " is " + total);
    }

    public int printTable(String header, String content, String footer, Map<Product, Integer> billItem, int sum, Set<Product> products) {
        System.out.println("┌──────────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Product", "Quantity", "Price", "Total");
        for (Product product : products) {
            System.out.println("├──────────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), billItem.get(product),
                    product.getPrice(), product.getPrice() * billItem.get(product));
            sum += product.getPrice() * billItem.get(product);
        }
        System.out.println("├──────────────────────────────────────────────────────────────────┤");
        System.out.printf(footer, "Total amount:", sum);
        System.out.println("└──────────────────────────────────────────────────────────────────┘");
        return sum;
    }

    public void printProduct(List<Product> lists) {
        String header = "│ %-2s │ %-30s │ %-10s │ %-9s │ %-8s │ %10s │ %-50s │\n";
        String content = "│ %-2d │ %-30s │ %-10s │ %-9s │ %-8d │ %10d │ %-50s │\n";
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf(header, "ID", "Name", "Brand", "Category", "Quantity", "Price", "Description");
        for (Product product : lists) {
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.printf(content, product.getId(), product.getName(), product.getBrand(), product.getCategory().getName(),
                    product.getQuantity(), product.getPrice(), product.getDescription());
        }
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public void printUserInformation(User user) {
        String email = (user.getEmail() == null ) ? "" : user.getEmail();
        String address = (user.getAddress() == null ) ? "" : user.getAddress();
        String phoneNUmber = (user.getPhoneNumber() == null ) ? "" : user.getPhoneNumber();
        String format = "│ %-12s │ %-30s │\n";
        System.out.println("\uD83D\uDC64 User information:");
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "User name", user.getUsername());
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Balance", user.getBalance() + " VND");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Email", email);
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Address", address);
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "Phone number", phoneNUmber);
        System.out.println("└───────────────────────────────────────────────┘");
    }

    public void printChatBox(User userOne, User userTwo, ChatSession chatSession) {
        String userOneName = userOne.getUsername();
        String userTwoName = userTwo.getUsername();
        List<Messenger> messengerList = chatSession.getMessengerList();
        String userOneFormat = "│ %-70s │\n";
        String userTwoFormat = "│ %70s │\n";
        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.printf(userOneFormat, userOneName + " & " + userTwoName + " chat box");
        System.out.println("├────────────────────────────────────────────────────────────────────────┤");
        for (Messenger messenger : messengerList) {
            if (messenger.getMessID().getUsername().equals(userOne.getUsername())) {
                System.out.printf(userOneFormat, messenger.getMessage());
                System.out.printf(userOneFormat, messenger.getTime().toString());
            }
            if (messenger.getMessID().getUsername().equals(userTwo.getUsername())) {
                System.out.printf(userTwoFormat, messenger.getMessage());
                System.out.printf(userTwoFormat, messenger.getTime().toString());
            }
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
    }

    public void printNotification(User user) {
        List<Messenger> notification = user.getNotification();
        String format = "│ %-70s │\n";
        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.printf(format, "\uD83D\uDC64 " + user.getUsername() + " notification:");
        System.out.println("├────────────────────────────────────────────────────────────────────────┤");
        for (Messenger messenger : notification) {
            System.out.printf(format, messenger.getMessage());
            System.out.printf(format, messenger.getTime());
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
    }
}
