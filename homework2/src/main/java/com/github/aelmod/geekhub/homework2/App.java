package com.github.aelmod.geekhub.homework2;


import com.github.aelmod.geekhub.homework2.core.*;

import static com.github.aelmod.common.util.ConsoleUtils.*;

/**
 * Created by aelmod-notebook on 30.10.2016.
 */
public class App {

    public static void main(String[] args) {
        Shape shape = getShapeFromUser();
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Primeter: " + shape.calculatePerimeter());
    }

    private static Shape getShapeFromUser() {
        for (int i = 0; i < ShapeType.values().length; i++) {
            System.out.println(i + ":" + ShapeType.values()[i]);
        }


        System.out.print("Enter a shape number: ");
        int shapeNumber = getIntFromUser(0, ShapeType.values().length - 1);

        ShapeType shapeType = ShapeType.values()[shapeNumber];

        return getShapeByShapeType(shapeType);

    }

    private static Shape getShapeByShapeType(ShapeType shapeType) {
        switch (shapeType) {
            case CIRCLE:
                System.out.print("Enter circle radius: ");
                return new Circle(getDoubleFromUser());
            case SQUARE:
                System.out.print("Enter square side size: ");
                return new Square(getDoubleFromUser());
            case RECTANGLE:
                System.out.println("Enter rectangle sides: ");
                return new Rectangle(getDoubleFromUser(), getDoubleFromUser());
            case TRIANGLE:
                while (true) {
                    try {
                        System.out.println("Enter triangle sides: ");
                        return new Triangle(getDoubleFromUser(), getDoubleFromUser(), getDoubleFromUser());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                }
            default:
                throw new IllegalArgumentException("Неверно введено имя фигуры");

        }
    }


}

