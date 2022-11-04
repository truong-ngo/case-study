package product;

import java.awt.*;
import java.io.Serializable;

public class EarBuds extends Product implements Serializable {
    private static final long serialVersionUID = 42L;
    private String connectType;
    boolean waterResistance;

    public EarBuds(String name, String brand, int price, int quantity, Category category, String connectType, boolean isWaterResistance) {
        super(name, brand, price, quantity, category);
        this.connectType = connectType;
        this.waterResistance = isWaterResistance;
    }

    public String getConnectType() {
        return connectType;
    }

    public void setConnectType(String connectType) {
        this.connectType = connectType;
    }

    public boolean isWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(boolean waterResistance) {
        this.waterResistance = waterResistance;
    }

    @Override
    public String getDescription() {
        String content = (waterResistance) ? "yes" : "no";
        return "connect type: " + connectType + ", water resistance: " + content;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(getPrice(),product.getPrice());
    }
}
