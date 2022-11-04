package product;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 42L;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
