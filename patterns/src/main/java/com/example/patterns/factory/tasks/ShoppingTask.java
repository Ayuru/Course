package com.example.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;

    private double quantity;

    private boolean executed = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
