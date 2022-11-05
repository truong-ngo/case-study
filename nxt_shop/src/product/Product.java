package product;

import java.io.Serializable;

public abstract class Product implements Serializable,Comparable<Product> {
    private static final long serialVersionUID = 42L;
    private static Integer ID_COUNT = 0;
    private Integer id;
    private String name;
    private String brand;
    private int price;
    private int quantity;
    private Category category;

    public Product(String name, String brand, int price, int quantity, Category category) {
        id = ++ID_COUNT;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public void setIdCount(int newCount) {
        Product.ID_COUNT = newCount;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getDescription();

    @Override
    public abstract int compareTo(Product product);
}
