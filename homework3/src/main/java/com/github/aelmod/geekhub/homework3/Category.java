package com.github.aelmod.geekhub.homework3;

/**
 * Created by Євгеній on 05.11.2016.
 */
public class Category {
    private int id;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return id;
    }

    public void setCategoryId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
