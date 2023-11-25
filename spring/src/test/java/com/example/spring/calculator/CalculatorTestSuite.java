package com.example.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CalculatorTestSuite {

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double sum = calculator.add(3.3, 2.2);
        double difference = calculator.sub(1.8, 0.7);
        double product = calculator.mul(6.6, 2.5);
        double quotient = calculator.div(14.7, 0.7);

        //Then
        assertEquals(5.5, sum);
        assertEquals(1.1, difference);
        assertEquals(16.5, product);
        assertEquals(21.0, quotient);
    }

}

