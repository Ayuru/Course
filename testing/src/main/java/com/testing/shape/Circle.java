package com.testing.shape;

public class Circle implements Shape {

    private double radius;
    private double field = Math.PI * Math.pow(radius, 2);

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return field;
    }
}
