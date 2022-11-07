package shop_item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 42L;
    private String username;
    private String password;
    private int balance;
    private String email;
    private String phoneNumber;
    private String role;
    private List<Messenger> notification;

    public User() {

    }


    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
        balance = 0;
        role = "USER";
        notification = new ArrayList<>();
    }

    public void addNotification(Messenger messenger) {
        notification.add(messenger);
    }

    public void clearNotification() {
        notification.clear();
    }

    public List<Messenger> getNotification() {
        return notification;
    }

    public void setNotification(List<Messenger> notification) {
        this.notification = notification;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
