package com.testing.shape;

public class Square implements Shape {

    private int field;

    public Square(int field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public int getField() {
        return field;
    }
}
