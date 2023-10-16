package com.testing.shape;

import com.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Test Suite \uD83D\uDC80")

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Testing methods which can change object.")
    class TestModifications {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle(12, 12));

            //When
            int numberOfFigures = shapeCollector.getListOfShapes().size();

            //Then
            Assertions.assertEquals(1, numberOfFigures);

        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(22);
            shapeCollector.addFigure(shape);
            shapeCollector.removeFigure(shape);

            //When
            int numberOfFigures = shapeCollector.getListOfShapes().size();

            //Then
            Assertions.assertEquals(0, numberOfFigures);
        }
    }

    @DisplayName("Testing methods which gather data.")
    @Nested
    class TestQuestions {
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(17);
            shapeCollector.addFigure(shape);

            //When
            Shape askedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(shape, askedShape);

        }


        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle(3, 7));
            shapeCollector.addFigure(new Circle(6));
            shapeCollector.addFigure(new Square(9));

            //When
            String figures = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("Triangle, Circle, Square", figures);

        }

    }

}