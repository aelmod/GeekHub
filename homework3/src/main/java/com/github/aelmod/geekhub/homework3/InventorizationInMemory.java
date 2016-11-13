package com.github.aelmod.geekhub.homework3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Євгеній on 05.11.2016.
 */
public class InventorizationInMemory implements Inventorization {
    private List<Category> categoriesList = new ArrayList<>();
    private List<Product> productsList = new ArrayList<>();

    public BigDecimal getInventoryValueSum() {
        BigDecimal sum = new BigDecimal(0);
        for (Product products : productsList) {
            sum = sum.add(products.getPrice());
        }
        return sum;
    }

    public void addCategory(Category category) {
        categoriesList.add(category);
    }

    public void deleteCategories(Category category, Category... categories) {
        categoriesList.remove(category);
        for (Category c : categories) {
            categoriesList.remove(c);
        }
    }

    public Category[] getAllCategories() {
        return categoriesList.toArray(new Category[categoriesList.size()]);
    }

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public void deleteProducts(Product product, Product... products) {
        productsList.remove(product);
        for (Product c : products) {
            productsList.remove(c);
        }
    }

    public Product[] getAllProducts() {
        return productsList.toArray(new Product[productsList.size()]);
    }

    public Product[] getAllProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : productsList) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result.toArray(new Product[productsList.size()]);
    }

}
