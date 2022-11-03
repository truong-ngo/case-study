package product;

import java.io.Serializable;

public class Mobile extends Product implements Serializable {
    private String networkType;
    private String refreshRate;

    public Mobile(int id, String name, String brand, int price, int quantity, Category category, String networkType, String refreshRate) {
        super(id, name, brand, price, quantity, category);
        this.networkType = networkType;
        this.refreshRate = refreshRate;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
    }

    @Override
    public String getDescription() {
        return getCategory().getName() + ", network type: " + networkType +
               ", refresh rate: " + refreshRate;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(getPrice(),product.getPrice());
    }
}
