package manager;

import menu.Resource;
import product.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager implements ManagerList<Product>, Serializable {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        Product mobile = new Mobile(1,"Pixel 7","Google", 18000000, 10, new Category("Mobile", "Electric Device"), "5g", "90Hz");
        Product laptop = new Laptop(2,"Surface 5","Microsoft", 27000000, 10, new Category("Laptop", "Electric Device"), "14 inch", "compact");
        Product earBud = new EarBuds(3,"LG FN4","LG", 1000000, 10, new Category("Ear Buds", "Accessories"), "bluetooth", true);
        products.add(mobile);
        products.add(laptop);
        products.add(earBud);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void add(Product item) {
        products.add(item);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    public void displayAll(Resource resource) {
        List<Product> list = products;
        resource.printer.productManagerPrinter.printProduct(list);
    }

    public void displayByPrice(Resource resource) {
        List<Product> list = products;
        List<Product> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        resource.printer.productManagerPrinter.printProduct(sortedList);
    }

    public void searchByName(String name, Resource resource) {
        List<Product> lists = products;
        List<Product> searchLists = resource.input.productInput.checkName(name, lists);
        if (searchLists.isEmpty()) {
            System.out.println("⛔ No match product");
        } else {
            System.out.println("☑ Search result: ");
            resource.printer.productManagerPrinter.printProduct(searchLists);
        }
    }

    public void searchByBrand(String name, Resource resource) {
        List<Product> lists = products;
        List<Product> searchLists = resource.input.productInput.checkBrand(name, lists);
        if (searchLists.isEmpty()) {
            System.out.println("⛔ No match product");
        } else {
            System.out.println("☑ Search result: ");
            resource.printer.productManagerPrinter.printProduct(searchLists);
        }
    }

    public boolean checkId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
