package input;

import shop_item.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public Pattern pattern;
    public Matcher matcher;

    public boolean validate(String data, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public boolean validateChoice(String choice, int start, int end) {
        if (validate(choice, Regex.NUMBER)) {
            int number = Integer.parseInt(choice);
            return number >= start && number <= end;
        }
        return false;
    }

    public boolean validateNumber(String number) {
        return validate(number, Regex.NUMBER);
    }

    public boolean validateEmail(String email) {
        return validate(email, Regex.EMAIL);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return validate(phoneNumber, Regex.PHONE_NUMBER);
    }

    public boolean validateStringWithoutNull(String string) {
        return !string.equals("");
    }

    public boolean validateUser(String[] data, List<User> users) {
        for (User user : users) {
            if (data[0].equals(user.getUserName()) && data[1].equals(user.getPassword())
                    && user.getRole().equals("USER")) {
                return true;
            }
        }
        return false;
    }
}
