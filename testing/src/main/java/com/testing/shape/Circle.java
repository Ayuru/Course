package com.testing.shape;

public class Circle implements Shape {
    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public int getField() {
        return 20;
    }
}
