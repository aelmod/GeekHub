package com.github.aelmod.geekhub.homework2.core;

import java.lang.Math;

/**
 * Created by aelmod-notebook on 30.10.2016.
 */
public class Circle implements Shape {

    final static double PI = 3.14;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 2*PI*Math.pow(radius,2);
    }

    public double calculatePerimeter() {
        return 2*PI*radius;
    }
}
