package com.github.aelmod.geekhub.homework3;

import java.math.BigDecimal;

/**
 * Created by Євгеній on 06.11.2016.
 */
public interface Inventorization {
    Class<? extends Inventorization>[] INVENTORIZATIONS = new Class[]{InventoryJdbc.class, InventorizationInMemory.class};

    BigDecimal getInventoryValueSum();

    void addCategory(Category category);

    void deleteCategories(Category category, Category... categories);

    Category[] getAllCategories();

    void addProduct(Product product);

    void deleteProducts(Product product, Product... products);

    Product[] getAllProducts();

    Product[] getAllProductsByCategory(Category category);

    default void productCurrentCountUpdate(Product product) {
    }

    default void productSingOutUpdate(Product product) {
    }
}
