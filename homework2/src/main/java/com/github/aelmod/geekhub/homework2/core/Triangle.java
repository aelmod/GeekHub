package com.github.aelmod.geekhub.homework2.core;

/**
 * Created by aelmod-notebook on 30.10.2016.
 */
public class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a+b<c||a+c<b||b+c<a){
            throw new IllegalArgumentException("Triangle is invalid");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public double calculatePerimeter() {
        return a + b + c;
    }
}
