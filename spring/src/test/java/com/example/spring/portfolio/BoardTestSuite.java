package com.example.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {


    @Test
    public void testTaskAdd() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.spring");
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("to do");
        board.getInProgressList().getTasks().add("in progress");
        board.getDoneList().getTasks().add("completed");

        //Then
        assertEquals("to do", board.getToDoList().getTasks().get(0));
        assertEquals("in progress", board.getInProgressList().getTasks().get(0));
        assertEquals("completed", board.getDoneList().getTasks().get(0));

    }
}
