package product;

import java.awt.*;
import java.io.Serializable;

public class EarBuds extends Product implements Serializable {
    private String connectType;
    boolean waterResistance;

    public EarBuds(int id, String name, String brand, int price, int quantity, Category category, String connectType, boolean isWaterResistance) {
        super(id, name, brand, price, quantity, category);
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
        return getCategory().getName() + ", connect type: " +
               connectType + ", water resistance: " + waterResistance;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(getPrice(),product.getPrice());
    }
}
