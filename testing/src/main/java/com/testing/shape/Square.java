package com.testing.shape;

public class Square implements Shape {

    private double side;
    private double field = Math.pow(side, 2);

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return field;
    }
}
