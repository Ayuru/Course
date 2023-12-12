package com.example.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static com.example.patterns.factory.tasks.TaskFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.createTask(DRIVING);

        //Then
        assertEquals("capture a victim", driving.getTaskName());

    }

    @Test
    void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.createTask(PAINTING);

        //Then
        assertEquals("paint the basement", painting.getTaskName());

    }

    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.createTask(SHOPPING);
        //Then

        assertEquals("buy", shopping.getTaskName());

    }
}
