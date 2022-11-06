package input;

import menu.Resource;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidate {
    public static Pattern pattern;
    public static Matcher matcher;

    public static boolean validate(String data, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static boolean validateMenuChoice(String choice, String numberRegex, int start, int end) {
        if (validate(choice, numberRegex)) {
            int number = Integer.parseInt(choice);
            return number >= start && number <= end;
        }
        return false;
    }
}
