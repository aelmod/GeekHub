package HomeWork2.core;

/**
 * Created by aelmod-notebook on 30.10.2016.
 */
public class Square implements Shape {
    private Triangle triangle1;
    private Triangle triangle2;
    private double side;

    public Square(double side) {
        triangle1 = new Triangle(side, side, Math.sqrt(2 * side * side));
        triangle2 = new Triangle(side, side, Math.sqrt(2 * side * side));
        this.side = side;
    }

    public double calculateArea() {
        return triangle1.calculateArea() + triangle2.calculateArea();
    }

    public double calculatePerimeter() {
        return 4 * side;
    }
}
