package manager;

import input.GeneralInput;
import io_file.IOFile;
import menu.Resource;
import printer.GeneralPrinter;
import product.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ManagerList<Product> {
    private final List<Product> products;
    private final IOFile<Product> ioFile;
    private final String path = "src/file/products";

    public ProductManager() {
        ioFile = new IOFile<>();
        products = ioFile.readFile(path);
        if (!products.isEmpty()) {
            int id = getLast().getId();
            getLast().setIdCount(id);
        }
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

    public void displayAll(GeneralPrinter printer) {
        printer.table.printProduct(products);
    }

    public void displayByPrice(Resource resource) {
        List<Product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList);
        resource.printer.table.printProduct(sortedList);
    }

    public boolean searchByName(String name, GeneralPrinter printer, GeneralInput input) {
        List<Product> searchLists = input.productInput.checkName(name, products);
        if (searchLists.isEmpty()) {
            printer.error.noMatchProduct();
            return false;
        } else {
            printer.notification.searchResult();
            printer.table.printProduct(searchLists);
            return true;
        }
    }

    public boolean searchByBrand(String name, GeneralPrinter printer, GeneralInput input) {
        List<Product> searchLists = input.productInput.checkBrand(name, products);
        if (searchLists.isEmpty()) {
            printer.error.noMatchProduct();
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
}
