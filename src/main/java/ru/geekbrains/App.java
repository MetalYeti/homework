package ru.geekbrains;

import ru.geekbrains.builder.Person;
import ru.geekbrains.polimorphism.Circle;
import ru.geekbrains.polimorphism.Shape;
import ru.geekbrains.polimorphism.Square;
import ru.geekbrains.polimorphism.Triangle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //1.

        Person person = Person.getBuilder()
                .setFirstName("Вася")
                .setLastName("Пупкин")
                .setAge(28)
                .setGender("М")
                .build();

        System.out.println(person);

        //3.
        Square s = new Square(4.5);
        Circle c = new Circle(5.25);
        Triangle t = new Triangle(1.25, 2.0, 3.1);

        System.out.println(calculateSquare(s));
        System.out.println(calculateSquare(c));
        System.out.println(calculateSquare(t));

    }

    public static double calculateSquare(Shape shape) {
        return shape.square();
    }

}
