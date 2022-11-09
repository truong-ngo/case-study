package input;

import shop_item.User;

public class BillInput {
    public String notificationFromUser(User user) {
         return "You got message from " + user.getUsername();
    }
}
