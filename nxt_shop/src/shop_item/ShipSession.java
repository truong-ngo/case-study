package shop_item;

import manager.UserManager;
import menu.UserMenu;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ShipSession implements Serializable, Runnable {
    private static final long serialVersionUID = 42L;
    private User shipID;
    private UserBills.Bill bill;

    public ShipSession(User shipID, UserBills.Bill bill) {
        this.shipID = shipID;
        this.bill = bill;
    }

    @Override
    public void run() {
        try {
            String prepareContext = "The seller is preparing the order, bill ID: " + bill.getBillNo();
            LocalDateTime prepareTime = LocalDateTime.now();
            Messenger prepareMess = new Messenger(prepareContext, prepareTime);
            shipID.addNotification(prepareMess);
            Thread.sleep(5000);
            String shipContext = "Goods are being delivered, please check your address";
            String address = shipID.getAddress();
            LocalDateTime shipTime = LocalDateTime.now();
            Messenger shipMess = new Messenger(shipContext, shipTime);
            Messenger addressMess = new Messenger(address, shipTime);
            shipID.addNotification(shipMess);
            shipID.addNotification(addressMess);
            Thread.sleep(10000);
            String completeContext = "Delivery successful";
            LocalDateTime completeTime = LocalDateTime.now();
            Messenger completeMess = new Messenger(completeContext, completeTime);
            shipID.addNotification(completeMess);
            UserManager userManager = UserManager.getInstance();
            userManager.saveUserList();
        } catch (InterruptedException exception) {
            String failContext = "Shipping fail";
            LocalDateTime failTime = LocalDateTime.now();
            Messenger failMess = new Messenger(failContext, failTime);
            shipID.addNotification(failMess);
        }
    }
}
