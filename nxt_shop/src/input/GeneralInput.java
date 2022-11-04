package input;

public class GeneralInput {
    public Validate validate;
    public LoginAndUserInput loginAndUserInput;
    public ProductInput productInput;
    public CartInput cartInput;

    public GeneralInput() {
        validate = new Validate();
        loginAndUserInput = new LoginAndUserInput();
        productInput = new ProductInput();
        cartInput = new CartInput();
    }
}
