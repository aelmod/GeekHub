package com.github.aelmod.geekhub.homework6.task3;

/**
 * Created by Євгеній on 28.11.2016.
 */
public class Car {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}