package input;

public class Input {
    public Validate validate;
    public UserInput user;
    public ProductInput product;
    public CartInput cart;
    public BillInput bill;

    public Input() {
        validate = new Validate();
        user = new UserInput();
        product = new ProductInput();
        cart = new CartInput();
        bill = new BillInput();
    }
}
