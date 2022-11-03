package input;

public class ValidateMenuChoice extends Input {
    public boolean validateHomePageChoice(String choice) {
        return validate(choice, Regex.HOME_PAGE_CHOICE);
    }

    public boolean validateLoginChoice(String choice) {
        return validate(choice, Regex.LOGIN_SIGNUP_CHOICE);
    }

    public boolean validateGuestPageChoice(String choice) {
        return validate(choice, Regex.GUEST_CHOICE);
    }

    public boolean validateSearchChoice(String choice) {
        return validate(choice, Regex.SEARCH_CHOICE);
    }

    public boolean validateCartChoice(String choice) {
        return validate(choice, Regex.USER_CHOICE);
    }

    public boolean validateAddToCartChoice(String choice) {
        return validate(choice, Regex.ADD_TO_CART_CHOICE);
    }

    public boolean validateIdInput(String choice) {
        return validate(choice, Regex.ID_INPUT);
    }

    public boolean validateQuantityInput(String choice) {
        return validate(choice, Regex.QUANTITY_INPUT);
    }

    public boolean validateCartManagerChoice(String choice) {
        return validate(choice, Regex.CART_MANAGER_CHOICE);
    }

    public boolean validateAccountManagerChoice(String choice) {
        return validate(choice, Regex.ACCOUNT_MANAGER_CHOICE);
    }
}
