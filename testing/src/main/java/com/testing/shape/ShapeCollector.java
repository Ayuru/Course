package com.testing.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeCollector {

    private List<Shape> listOfShapes = new ArrayList<>();


    public List<Shape> getListOfShapes() {
        return listOfShapes;
    }

    public List<Shape> addFigure(Shape shape) {

        listOfShapes.add(shape);

        return listOfShapes;

    }

    public List<Shape> removeFigure(Shape shape) {

        listOfShapes.remove(shape);

        return listOfShapes;

    }

    public Shape getFigure(int n) {

        return listOfShapes.get(n);

    }

    public String showFigures() {

        String figures = "";

        for (int i = 0; i < listOfShapes.size(); i++) {
            figures = figures + listOfShapes.get(i).getShapeName();
            if (i < listOfShapes.size() - 1) {
                figures = figures + ", ";
            }
        }

        return figures;

    }
}
