package com.github.aelmod.geekhub.homework2.core;

/**
 * Created by aelmod-notebook on 30.10.2016.
 */
public class Rectangle implements Shape {

    private double side1, side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public double calculateArea() {
        return side1 + side2;
    }

    public double calculatePerimeter() {
        return  side1 * side2;
    }
}
