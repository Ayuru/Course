package com.example.patterns.factory.tasks;

public class DrivingTask implements Task {
    private String taskName;
    private String where;

    private String using;

    private boolean executed = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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
