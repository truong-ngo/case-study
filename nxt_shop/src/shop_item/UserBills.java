package shop_item;

import product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserBills implements Serializable {
    private static final long serialVersionUID = 42L;
    private final User billsId;
    private final List<Bill> bills;

    public UserBills(User user) {
        billsId = user;
        bills = new ArrayList<>();
    }

    public User getBillsId() {
        return billsId;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void addBill(UserBills.Bill bill) {
        bills.add(bill);
    }

    public int getUserTotalSpent() {
        int totalSpent = 0;
        for (Bill bill : bills) {
            totalSpent += bill.getBillAmount();
        }
        return totalSpent;
    }

    public class Bill implements Serializable {
        private static final long serialVersionUID = 42L;
        Map<Product, Integer> listItem;
        LocalDateTime paymentTime;
        public Bill() {

        }

        public Map<Product, Integer> getListItem() {
            return listItem;
        }

        public LocalDateTime getPaymentTime() {
            return paymentTime;
        }

        public void setListItem(Map<Product, Integer> listItem) {
            this.listItem = listItem;
        }

        public void setPaymentTime(LocalDateTime paymentTime) {
            this.paymentTime = paymentTime;
        }

        public void add(Map<Product, Integer> listItem, LocalDateTime paymentTime) {
            setListItem(listItem);
            setPaymentTime(paymentTime);
        }

        public int getBillAmount() {
            int billAmount = 0;
            Set<Product> products = listItem.keySet();
            for (Product product : products) {
                int sum = product.getPrice() * listItem.get(product);
                billAmount += sum;
            }
            return billAmount;
        }
    }
}


