package input;

public class GeneralInput {
    public ValidateMenuChoice validateMenuChoice;
    public LoginInput loginInput;
    public ProductInput productInput;

    public CartInput cartInput;

    public GeneralInput() {
        validateMenuChoice = new ValidateMenuChoice();
        loginInput = new LoginInput();
        productInput = new ProductInput();
        cartInput = new CartInput();
    }
}
