package com.github.aelmod.geekhub.homework3;

import java.math.BigDecimal;

/**
 * Created by Євгеній on 05.11.2016.
 */
public class Product {
    private int id;
    private int currentCount;
    private BigDecimal price;
    private String name;
    private int quantityOnHand;
    private Category category;

    public Product(String name, Category category, BigDecimal price, int currentCount) {
        this.currentCount = currentCount;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public Product(int id, String name, Category category, BigDecimal price, int currentCount) {
        this.id = id;
        this.currentCount = currentCount;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductName() {
        return name;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public Category getCategory() {
        return category;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void addToCurrentCount(int count) {
        currentCount += count;
    }

    public void signOut(int count) {
        if (count >= currentCount) {
            throw new IllegalArgumentException("You can't sign out more than " + currentCount + " items");
        }
        currentCount -= count;
        quantityOnHand += count;
    }

    public BigDecimal total() {
        return price.multiply(new BigDecimal(currentCount));
    }
}
