package com.testing.shape;

public class Triangle implements Shape {

    private int field;

    public Triangle(int field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public int getField() {
        return field;
    }
}
