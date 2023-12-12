package com.example.patterns.factory.tasks;

public class PaintingTask implements Task {

    private String taskName;
    private String color;

    private String whatToPaint;

    private boolean executed = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }


    public String getTaskName() {
        return taskName;
    }

    public void executeTask() {
        executed = true;
    }

    public boolean isTaskExecuted() {
        return executed;
    }
}
