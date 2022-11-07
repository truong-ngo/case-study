package manager;

import io_file.IOFile;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;

public class BillManager {
    private static BillManager instance;
    private List<UserBills> userBillsList;
    private final IOFile<UserBills> ioFile;
    private final String path = "src/file/bills";

    private BillManager() {
        ioFile = new IOFile<>();
        userBillsList = ioFile.readFile(path);
    }

    public static BillManager getInstance() {
        if (instance == null) {
            instance = new BillManager();
        }
        return instance;
    }

    public UserBills getUserBillsByUser(User user) {
        for (UserBills bills : userBillsList) {
            if (bills.getBillsID().getUserName().equals(user.getUserName())) {
                return bills;
            }
        }
        return null;
    }

    public int getTotalIncome() {
        int totalIncome = 0;
        for (UserBills bills : userBillsList) {
            totalIncome += bills.getUserTotalSpent();
        }
        return totalIncome;
    }

    public void saveUserBillsList() {
        ioFile.writeToFile(userBillsList,path);
    }

    public void add(UserBills item) {
        userBillsList.add(item);
        saveUserBillsList();
    }
}
