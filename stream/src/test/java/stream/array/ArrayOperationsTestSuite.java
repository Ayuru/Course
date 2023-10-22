package stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = {2, 4, 6, 8, 9, 11, 13, 15};
        //When
        double mean = ArrayOperations.getAverage(numbers);
        //Then
        assertEquals(8.5, mean);
    }
}
