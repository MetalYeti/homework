package ru.geekbrains.polimorphism;

public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
