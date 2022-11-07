package shop_item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatSession implements Serializable {
    private static final long serialVersionUID = 42L;
    private String sessionID;
    private User userOne;
    private User userTwo;
    private List<Messenger> messengerList;

    public ChatSession(User userOne, User userTwo) {
        this.userOne = userOne;
        this.userTwo = userTwo;
        sessionID = userOne.getUsername() + "&" + userTwo.getUsername();
        messengerList = new ArrayList<>();
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    public List<Messenger> getMessengerList() {
        return messengerList;
    }

    public void setMessengerList(List<Messenger> messengerList) {
        this.messengerList = messengerList;
    }

    public void addMessenger(Messenger messenger) {
        messengerList.add(messenger);
    }
}
