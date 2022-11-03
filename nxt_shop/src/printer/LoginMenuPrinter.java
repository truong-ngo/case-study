package printer;

public class LoginMenuPrinter {
    public void printSignInMenu() {
        String format = "│ %-45s │\n";
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf(format, "SIGN IN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Log in as user.");
        System.out.printf(format, "▶[2]. Log in as admin.");
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
}
