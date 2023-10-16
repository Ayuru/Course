package com.testing.shape;

public class Circle implements Shape {

    private int field;

    public Circle(int field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public int getField() {
        return field;
    }
}
