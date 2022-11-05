package input;

public class Validate extends Input {
    public boolean validateHomePageChoice(String choice) {
        return validate(choice, Regex.HOME_PAGE_CHOICE);
    }

    public boolean validateSignupChoice(String choice) {
        return validate(choice, Regex.SIGNUP_CHOICE);
    }
    public boolean validateLoginChoice(String choice) {
        return validate(choice, Regex.LOGIN_CHOICE);
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
        return validate(choice, Regex.INPUT_NUMBER_DATA);
    }

    public boolean validateCartManagerChoice(String choice) {
        return validate(choice, Regex.CART_MANAGER_CHOICE);
    }

    public boolean validateInputNumberData(String choice) {
        return validate(choice, Regex.INPUT_NUMBER_DATA);
    }

    public boolean validateAccountManagerChoice(String choice) {
        return validate(choice, Regex.ACCOUNT_MANAGER_CHOICE);
    }

    public boolean validateAccountUpdateChoice(String choice) {
        return validate(choice, Regex.ACCOUNT_UPDATE_CHOICE);
    }

    public boolean validateEmail(String email) {
        return validate(email, Regex.EMAIL_REGEX);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return validate(phoneNumber, Regex.PHONE_REGEX);
    }

    public boolean validateAdminMenuChoice(String choice) {
        return validate(choice, Regex.ADMIN_MENU_CHOICE);
    }

    public boolean validateUserManagerChoice(String choice) {
        return validate(choice, Regex.USER_MANAGER_CHOICE);
    }
}
