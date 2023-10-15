package com.testing;

import com.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        Calculator calculator = new Calculator();
        int additionResult = calculator.add(5, 4);

        System.out.println("Addition test:");
        if (additionResult == 9) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }

        int subtractionResult = calculator.subtract(22, 7);

        System.out.println("Subtraction test:");
        if (subtractionResult == 15) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }

    }
}