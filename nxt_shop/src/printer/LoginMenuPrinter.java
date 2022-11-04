package printer;

import user.User;

public class LoginMenuPrinter {
    public void printSignInMenu() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "SIGN IN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Log in.");
        System.out.printf(format, "▶[2]. Forgot password?.");
        System.out.printf(format, "▶[0]. Return to Home Page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void printSignUpMenu() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "SIGN UP");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Sign up.");
        System.out.printf(format, "▶[0]. Return to Home Page.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void logInFail() {
        System.out.println("⛔ Wrong username or password.");
    }

    public void logInSuccessful() {
        System.out.println("✅ Log in successfully");
    }

    public void signUpSuccessful() {
        System.out.println("✅ Sign up successful");
    }

    public void userNameExist() {
        System.out.println("⛔ Username already exist");
    }

    public void passWordChanged() {
        System.out.println("✅ Password changed");
    }

    public void passWordNotChanged() {
        System.out.println("⛔ Password not change");
    }

    public void emailNotFound() {
        System.out.println("⛔ Email not found");
    }

    public void sendEmailContainPassWord(User user) {
        System.out.println("✉ Mail to user: " + user.getUserName());
        System.out.println("Your password is: " + user.getPassword());
        System.out.println("Please change password to ensure your privacy");
    }

    public void duplicateEmail() {
        System.out.println("⛔ Duplicate email");
    }

    public void duplicatePhoneNumber() {
        System.out.println("⛔ Duplicate phone number");
    }
}
