package manager;

import io_file.IOFile;
import shop_item.User;
import shop_item.UserBills;

import java.util.List;

public class BillManager implements ManagerList<UserBills> {
    private final List<UserBills> userBillsList;
    private final IOFile<UserBills> ioFile;
    private final String path = "src/file/user-bills-list";

    public BillManager() {
        ioFile = new IOFile<>();
        userBillsList = ioFile.readFile(path);
    }

    public UserBills getBillsByUser(User user) {
        for (UserBills bills : userBillsList) {
            if (bills.getBillsId().getUserName().equals(user.getUserName())) {
                return bills;
            }
        }
        return null;
    }

    public void saveUserBillsList() {
        ioFile.writeToFile(userBillsList,path);
    }

    @Override
    public void add(UserBills item) {
        userBillsList.add(item);
        ioFile.writeToFile(userBillsList, path);
    }

    @Override
    public void update(int id, UserBills obj) {

    }

    @Override
    public void delete(int id) {

    }
}
