package com.example.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("buy", "torture equipment", 6);
            case PAINTING:
                return new PaintingTask("paint the basement", "red", "what's possible");
            case DRIVING:
                return new DrivingTask("capture a victim", "dark alley", "black van");
            default:
                return null;
        }
    }
}
