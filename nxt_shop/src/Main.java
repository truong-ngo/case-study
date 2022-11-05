import shop_item.UserBills;
import shop_item.User;
import system.ShopSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopSystem system = new ShopSystem();
        system.run(scanner);
        UserBills bills = new UserBills(new User());
        UserBills.Bill bill = bills.new Bill();
    }
}