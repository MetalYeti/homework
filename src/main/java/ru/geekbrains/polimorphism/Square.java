package ru.geekbrains.polimorphism;

public class Square extends Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double square() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }
}
