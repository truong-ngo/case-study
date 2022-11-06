package input;

public class GeneralInput {
    public Validate validate;
    public UserInput user;
    public ProductInput productInput;
    public CartInput cartInput;

    public GeneralInput() {
        validate = new Validate();
        user = new UserInput();
        productInput = new ProductInput();
        cartInput = new CartInput();
    }
}
