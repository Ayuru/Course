package com.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;
    private double field = 0.5 * base * height;

    public Triangle(double base, double height) {

        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return field;
    }
}
