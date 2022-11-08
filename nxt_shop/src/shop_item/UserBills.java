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
    private static Integer COUNT_BILL = 0;
    private final User billsID;
    private final List<Bill> bills;
    private final List<ShipSession> shipHistory;


    public UserBills(User user) {
        billsID = user;
        bills = new ArrayList<>();
        shipHistory = new ArrayList<>();
    }

    public List<ShipSession> getShipHistory() {
        return shipHistory;
    }

    public void addShipSession(ShipSession shipSession) {
        shipHistory.add(shipSession);
    }

    public Bill getLastBill() {
        return bills.get(bills.size() - 1);
    }

    public User getBillsID() {
        return billsID;
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
        private int number;
        private String billNo;
        Map<Product, Integer> listItem;
        LocalDateTime paymentTime;
        public Bill() {
            if (!shipHistory.isEmpty()) {
                COUNT_BILL = getLastBill().getNumber();
            }
            number = ++COUNT_BILL;
            billNo = billsID.getUsername() + number;
        }

        public int getNumber() {
            return number;
        }

        public String getBillNo() {
            return billNo;
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


