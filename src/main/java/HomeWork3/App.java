package HomeWork3;

import java.math.BigDecimal;

import static util.ConsoleUtils.*;
import static util.ConsoleUtils.Color.*;

/**
 * Created by aelmod-notebook on 05.11.2016.
 */
public class App {
    private static Inventorization inventorization;

    public static void main(String[] args) {
        inventorization = new Inventorization();
        Category defaultCategory = new Category("Tools");
        inventorization.addCategory(defaultCategory);

        inventorization.addProduct(new Product("Spoon", defaultCategory, new BigDecimal(5), 10));
        inventorization.addProduct(new Product("Shovel", defaultCategory, new BigDecimal(50), 30));
        inventorization.addProduct(new Product("Fork", defaultCategory, new BigDecimal(6), 40));

        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            clearScreen();
            System.out.println("Main menu: ");
            System.out.println("1: Categories");
            System.out.println("2: Products");
            switch (getIntFromUser(1, 2)) {
                case 1:
                    showCategoriesMenu();
                    break;
                case 2:
                    showProductsMenu();
                    break;
            }
        }
    }

    private static void showProductsMenu() {
        while (true) {
            clearScreen();
            int selectedOption;
            System.out.println("Products menu: ");
            System.out.println("Inventory value sum: " + inventorization.getInventoryValueSum());
            System.out.println("-1: Main menu");
            System.out.println("0: Add product");

            Product[] products = inventorization.getAllProducts();
            for (int i = 0; i < products.length; i++) {
                System.out.println(i + 1 + ": " + cyan(products[i].getProductName()));
            }
            selectedOption = getIntFromUser(-1, products.length);
            if (selectedOption == -1) {
                return;
            }
            if (selectedOption == 0) {
                showCreationProductWizard();
            } else {
                showProductMenu(products[selectedOption - 1]);
            }
        }
    }

    private static void showProductMenu(Product product) {
        while (true) {
            clearScreen();
            System.out.println("Product " + green(product.getProductName()) + " menu: ");
            System.out.println("Product category: " + product.getCategory().getCategoryName());
            System.out.println("Product price: " + product.getPrice());
            System.out.println("Product current count: " + product.getCurrentCount());
            System.out.println("Quantity on hand: " + product.getQuantityOnHand());
            System.out.println("Total: " + product.total());
            System.out.println();
            System.out.println(red("0: Back"));
            System.out.println("1: Add to current count");
            System.out.println("2: Sign out by hand");
            System.out.println("3: Delete product");
            System.out.println("4: Navigate to " + green(product.getCategory().getCategoryName()) + " category");

            switch (getIntFromUser(0, 4)) {
                case 0:
                    return;
                case 1:
                    System.out.print("How many do you want to add to current count: ");
                    product.addToCurrentCount(getIntFromUser(1, Integer.MAX_VALUE));
                    break;
                case 2:
                    System.out.print("How many do you want to sign out(max: " + red("" + product.getCurrentCount()) + "):");
                    product.signOut(getIntFromUser(1, product.getCurrentCount()));
                    break;
                case 3:
                    inventorization.deleteProducts(product);
                    System.out.println("Product " + green(product.getProductName()) + " deleted");
                    System.out.println(red("0: Back"));
                    getIntFromUser(0, 0);
                    return;
                case 4:
                    showCategoryMenu(product.getCategory());
                    break;
            }
        }
    }

    private static void showCreationProductWizard() {
        clearScreen();
        System.out.print("Enter product name: ");
        String productName = getLineFromUser();

        Category[] allCategories = inventorization.getAllCategories();
        System.out.println("Change category: ");
        for (int i = 0; i < allCategories.length; i++) {
            System.out.println(i + ": " + cyan(allCategories[i].getCategoryName()));
        }
        Category category = allCategories[getIntFromUser(0, allCategories.length)];

        System.out.print("Enter product price: ");
        BigDecimal price = new BigDecimal(getIntFromUser());
        System.out.print("Enter product current count: ");
        int currentCount = getIntFromUser();

        inventorization.addProduct(new Product(productName, category, price, currentCount));
    }

    private static void showCategoriesMenu() {
        while (true) {
            clearScreen();
            int selectedOption;
            System.out.println("Category menu: ");
            System.out.println("-1: Main menu");
            System.out.println("0: Add category");

            Category[] categories = inventorization.getAllCategories();
            for (int i = 0; i < categories.length; i++) {
                System.out.println(i + 1 + ": " + cyan(categories[i].getCategoryName()));
            }

            selectedOption = getIntFromUser(-1, categories.length);
            if (selectedOption == -1) {
                return;
            }
            if (selectedOption == 0) {
                System.out.print("Enter new category name: ");
                inventorization.addCategory(new Category(getLineFromUser()));
            } else {
                showCategoryMenu(categories[selectedOption - 1]);
            }
        }
    }

    private static void showCategoryMenu(Category category) {
        while (true) {
            clearScreen();
            System.out.println("Category " + green(category.getCategoryName()) + " menu: ");
            System.out.println(red("0: Back"));
            System.out.println("1: Delete category");
            System.out.println("2: Show all products from category");
            switch (getIntFromUser(0, 2)) {
                case 0:
                    return;
                case 1:
                    inventorization.deleteCategories(category);
                    System.out.println("Category " + green(category.getCategoryName()) + " is deleted");
                    System.out.println(red("0: Back"));
                    getIntFromUser(0, 0);
                    return;
                case 2:
                    showAllProductsByCategory(category);
                    break;
            }
        }
    }

    private static void showAllProductsByCategory(Category category) {
        int selectedOption;
        while (true) {
            clearScreen();
            System.out.println("All products by " + green(category.getCategoryName()) + " category");
            System.out.println(red("0: Back"));
            Product[] products = inventorization.getAllProductsByCategory(category);
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ": " + cyan(products[i].getProductName()));
            }
            selectedOption = getIntFromUser(0, products.length);
            if (selectedOption == 0) {
                return;
            }
            showProductMenu(products[selectedOption - 1]);
            System.out.println();
        }
    }
}
