package com.example.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void getLastLogTest() {
        //Given
        Logger logger = Logger.INSTANCE;

        //When
        logger.log("Charizard!");
        logger.log("Pikachu!");


        //Then
        Assertions.assertEquals("Pikachu!", logger.getLastLog());
    }
}
