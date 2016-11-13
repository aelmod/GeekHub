package com.github.aelmod.geekhub.homework2.core;

/**
 * Created by Євгеній on 02.11.2016.
 */
public enum ShapeType {
    CIRCLE("Circle"), RECTANGLE("Rectangle"), SQUARE("Square"), TRIANGLE("Triangle");

    private String name;

    ShapeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
