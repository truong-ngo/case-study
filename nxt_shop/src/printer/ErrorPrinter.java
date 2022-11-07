package printer;

public class ErrorPrinter {
    public void itemNotFound(String item) {
        System.out.println("⛔ " + item + " not found");
    }

    public void itemAlreadyExist(String item) {
        System.out.println("⛔ " + item + " already exist");
    }

    public void actionFailed(String action) {
        System.out.println("⛔ " + action + " failed");
    }

    public void pleaseEnterData(String data) {
        System.out.println("⛔ Please enter " + data);
    }

    public void noMatchFound() {
        System.out.println("⛔ No match found");
    }

    public void invalidData(String data) {
        System.out.println("⛔ Invalid " + data);
    }

    public void incorrectData(String data) {
        System.out.println("⛔ Incorrect " + data);
    }

    public void exceedAmount(String data) {
        System.out.println("⛔ " + data + " exceed");
    }
}

