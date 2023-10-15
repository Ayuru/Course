package com.testing.collection;

import com.testing.collection.CollectionTestSuite;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin...");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end.");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin...");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end.");
    }

    @DisplayName("When the list is empty then OddNumbersExterminator should return empty list. ")

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> list = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        List<Integer> result = exterminator.exterminate(list);

        //Then
        Assertions.assertEquals(expectedResult, result);

    }

    @DisplayName("When the list contains odd numbers then OddNumbersExterminator should return list without them.")

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        Integer[] listArray = new Integer[]{3, 6, 7, 21, 66};
        Integer[] resultArray = new Integer[]{6, 66};
        List<Integer> list = new ArrayList<>(Arrays.asList(listArray));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(resultArray));
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        List<Integer> result = exterminator.exterminate(list);

        //Then
        Assertions.assertEquals(expectedResult, result);

    }


}
