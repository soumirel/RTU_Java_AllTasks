package rtu.task3.subtask2;

import static java.lang.Math.PI;

public class Circle extends Shape {
    protected double radius;

    public Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2* PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
