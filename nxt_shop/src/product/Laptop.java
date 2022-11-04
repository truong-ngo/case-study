package product;

import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    private static final long serialVersionUID = 42L;
    private String screenSize;
    private String keyBoardType;

    public Laptop(int id, String name, String brand, int price, int quantity, Category category, String screenSize, String keyBoardType) {
        super(id, name, brand, price, quantity, category);
        this.screenSize = screenSize;
        this.keyBoardType = keyBoardType;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getKeyBoardType() {
        return keyBoardType;
    }

    public void setKeyBoardType(String keyBoardType) {
        this.keyBoardType = keyBoardType;
    }

    @Override
    public String getDescription() {
        return getCategory().getName() + ", screen size: " +
               screenSize + ", keyboard type: " + keyBoardType;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(getPrice(),product.getPrice());
    }
}
