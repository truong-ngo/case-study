package shop_item;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 42L;
    private String userName;
    private String password;
    private int balance;
    private String email;
    private String phoneNumber;
    private String role;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        balance = 0;
        role = "USER";
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
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
