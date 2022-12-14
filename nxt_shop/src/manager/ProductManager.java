package manager;

import io_file.IOFile;
import printer.Printer;
import product.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager implements CRUD<Product> {
    private static ProductManager instance;
    private List<Product> products;
    private final IOFile<Product> ioFile;
    private final String path = "../file/products";

    private ProductManager() {
        ioFile = new IOFile<>();
        products = ioFile.readFile(path);
        setStaticNumber();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void setStaticNumber() {
        if (!products.isEmpty()) {
            int id = getLast().getId();
            getLast().setIdCount(id);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getLast() {
        int index = products.size() - 1;
        return products.get(index);
    }

    @Override
    public void add(Product item) {
        products.add(item);
        ioFile.writeToFile(products, path);
    }

    @Override
    public void update(int id, Product updateProduct) {
        int index = getIndexById(id);
        products.set(index, updateProduct);
        ioFile.writeToFile(products, path);
    }

    public int getIndexById(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void delete(int id) {
        if (checkId(id)) {
            products.remove(getProductById(id));
        }
        ioFile.writeToFile(products, path);
    }

    public void saveProductList() {
        ioFile.writeToFile(products, path);
    }

    public void readProductList() {
        products = ioFile.readFile(path);
    }

    public void displayAll(Printer printer) {
        printer.table.printProduct(products);
    }

    public void displayByPrice(Printer printer) {
        List<Product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList);
        printer.table.printProduct(sortedList);
    }

    public boolean searchByName(String name, Printer printer) {
        List<Product> searchLists = checkName(name);
        if (searchLists.isEmpty()) {
            printer.error.noMatchFound();
            return false;
        } else {
            printer.notification.searchResult();
            printer.table.printProduct(searchLists);
            return true;
        }
    }

    public boolean searchByBrand(String brand, Printer printer) {
        List<Product> searchLists = checkBrand(brand);
        if (searchLists.isEmpty()) {
            printer.error.noMatchFound();
            return false;
        } else {
            printer.notification.searchResult();
            printer.table.printProduct(searchLists);
            return true;
        }
    }

    public boolean searchByCategory(String category, Printer printer) {
        List<Product> searchLists = checkCategory(category);
        if (searchLists.isEmpty()) {
            printer.error.noMatchFound();
            return false;
        } else {
            printer.notification.searchResult();
            printer.table.printProduct(searchLists);
            return true;
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

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean checkDuplicateName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> checkName(String name) {
        List<Product> searchLists = new ArrayList<>();
        for (Product product : products) {
            String value = name.toLowerCase();
            String productName = product.getName().toLowerCase();
            if (productName.contains(value)) {
                searchLists.add(product);
            }
        }
        return searchLists;
    }

    public List<Product> checkBrand(String name) {
        List<Product> searchLists = new ArrayList<>();
        for (Product product : products) {
            String value = name.toLowerCase();
            String brand = product.getBrand().toLowerCase();
            if (brand.contains(value)) {
                searchLists.add(product);
            }
        }
        return searchLists;
    }

    public List<Product> checkCategory(String name) {
        List<Product> searchLists = new ArrayList<>();
        for (Product product : products) {
            String value = name.toLowerCase();
            String category = product.getCategory().getName().toLowerCase();
            if (category.contains(value)) {
                searchLists.add(product);
            }
        }
        return searchLists;
    }
}
