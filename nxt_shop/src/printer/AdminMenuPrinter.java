package printer;

import io_file.IOFile;
import product.EarBuds;
import product.Laptop;
import product.Mobile;
import product.Product;

import java.util.List;

public class AdminMenuPrinter {
    public final IOFile<String> ioFile;
    public final String path = "src/file/category-display-list";
    public List<String> categoryChoice;

    public AdminMenuPrinter() {
        ioFile = new IOFile<>();
        categoryChoice = ioFile.readFile(path);
        if (categoryChoice.isEmpty()) {
            categoryChoice.add("mobile");
            categoryChoice.add("laptop");
            categoryChoice.add("earbud");
        }
    }

    public void addProductMenuPrinter() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Add mobile.");
        System.out.printf(format, "▶[2]. Add laptop.");
        System.out.printf(format, "▶[3]. Add earbuds.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void updateProductMenuPrinter(Product product) {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Update name.");
        System.out.printf(format, "▶[2]. Update brand.");
        System.out.printf(format, "▶[3]. Update price.");
        System.out.printf(format, "▶[4]. Update quantity.");
        if (product instanceof Mobile) {
            System.out.printf(format, "▶[5]. Update network type.");
            System.out.printf(format, "▶[6]. Update refresh rate");
        }
        if (product instanceof Laptop) {
            System.out.printf(format, "▶[5]. Update screen size.");
            System.out.printf(format, "▶[6]. Update keyboard type.");
        }
        if (product instanceof EarBuds) {
            System.out.printf(format, "▶[5]. Update connect type.");
            System.out.printf(format, "▶[6]. Update water resistance.");
        }
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }

    public void productPropertyHasNotBeenUpdated(String property) {
        System.out.println("⏰ Product's " + property + " has not been updated");
    }

    public void productUpdateSuccessfully() {
        System.out.println("✅ Update successfully");
    }
    public void productDeleteSuccessfully() {
        System.out.println("✅ Delete successfully");
    }

    public void printUserManagerMenu() {
        String format = "│ %-45s │\n";
        System.out.println("┌─────────────────[Admin Page]──────────────────┐");
        System.out.printf(format, "ADMIN");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.printf(format, "▶[1]. Display user list.");
        System.out.printf(format, "▶[2]. View bill by user.");
        System.out.printf(format, "▶[3]. Display total income.");
        System.out.printf(format, "▶[0]. Return.");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("☞ Enter your choice:");
    }
}
