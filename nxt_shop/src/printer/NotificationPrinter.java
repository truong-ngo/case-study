package printer;

import shop_item.User;

public class NotificationPrinter {

    public void itemHasNotBeenUpdated(String item) {
        System.out.println("\uD83D\uDD14 " + item + " has not been updated");
    }

    public void itemListTitle() {
        System.out.println("\uD83D\uDCE6 Product list: ");
    }

    public void searchResult() {
        System.out.println("⏩ Search result: ");
    }

    public void itemIsEmpty(String item) {
        System.out.println("\uD83D\uDD14 " + item + " is empty");
    }

    public void totalIncomeDisplay(int totalIncome) {
        System.out.println("\uD83D\uDCB5 Total income of shop is: " + totalIncome + " VND");
    }

    public void notEnoughBalance() {
        System.out.println("\uD83D\uDD14 Your account doesn't have enough balance");
    }

    public void sendEmailContainPassword(User user) {
        System.out.println("✉ Mail to user: " + user.getUsername());
        System.out.println("Your password is: " + user.getPassword());
        System.out.println("Please change password to ensure your privacy");
    }
}
