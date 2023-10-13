package com.testing.collection;

import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++)
        {
            if(numbers.get(i) % 2 != 0) {
                numbers.remove(i);
                i--;
            }

        }

        return numbers;
    }
}
