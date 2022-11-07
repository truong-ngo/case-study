package printer;

import shop_item.User;

public class NotificationPrinter {

    public void itemNotChanged(String item) {
        System.out.println("⏰ " + item + " not change");
    }
    public void itemHasNotBeenUpdated(String item) {
        System.out.println("⏰ " + item + " has not been updated");
    }

    public void sendEmailContainPassword(User user) {
        System.out.println("✉ Mail to user: " + user.getUserName());
        System.out.println("Your password is: " + user.getPassword());
        System.out.println("Please change password to ensure your privacy");
    }

    public void pleaseFillName() {
        System.out.println("⏰ Please fill name field");
    }

    public void pleaseFillBrand() {
        System.out.println("⏰ Please fill brand field");
    }

    public void productListTitle() {
        System.out.println("⌚ Product list: ");
    }

    public void searchResult() {
        System.out.println("☑ Search result: ");
    }

    public void cartIsEmpty() {
        System.out.println("⏰ Cart is empty");
    }

    public void totalIncomeDisplay(int totalIncome) {
        System.out.println("Total income of shop is: " + totalIncome + " VND");
    }

    public void notEnoughBalance() {
        System.out.println("⏰ Your account doesn't have enough balance");
    }
}
