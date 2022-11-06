package input;

public class GeneralInput {
    public Validate validate;
    public UserInput user;
    public ProductInput product;
    public CartInput cart;

    public GeneralInput() {
        validate = new Validate();
        user = new UserInput();
        product = new ProductInput();
        cart = new CartInput();
    }
}
