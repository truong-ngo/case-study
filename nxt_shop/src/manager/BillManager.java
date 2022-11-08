package manager;

import io_file.IOFile;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;

public class BillManager {
    private static BillManager instance;
    private List<UserBills> billsList;
    private final IOFile<UserBills> ioFile;
    private final String path = "C:\\Learning\\Case-study\\file\\bills";

    private BillManager() {
        ioFile = new IOFile<>();
        billsList = ioFile.readFile(path);
    }

    public static BillManager getInstance() {
        if (instance == null) {
            instance = new BillManager();
        }
        return instance;
    }

    public UserBills getUserBillsByUser(User user) {
        for (UserBills bills : billsList) {
            if (bills.getBillsID().getUsername().equals(user.getUsername())) {
                return bills;
            }
        }
        return null;
    }

    public int getTotalIncome() {
        int totalIncome = 0;
        for (UserBills bills : billsList) {
            totalIncome += bills.getUserTotalSpent();
        }
        return totalIncome;
    }

    public void saveBillsList() {
        ioFile.writeToFile(billsList,path);
    }

    public void readBillsList() {
        billsList = ioFile.readFile(path);
    }

    public void add(UserBills item) {
        billsList.add(item);
        saveBillsList();
    }
}
