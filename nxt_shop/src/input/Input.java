package input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public Pattern pattern;
    public Matcher matcher;

    public boolean validate(String data, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
