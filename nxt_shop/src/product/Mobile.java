package product;

import java.io.Serializable;

public class Mobile extends Product implements Serializable {
    private static final long serialVersionUID = 42L;
    private String networkType;
    private String refreshRate;

    public Mobile(String name, String brand, int price, int quantity, Category category, String networkType, String refreshRate) {
        super(name, brand, price, quantity, category);
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
        return "network type: " + networkType + ", refresh rate: " + refreshRate;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(getPrice(),product.getPrice());
    }
}
