package com.bbva.birthdaycakecandles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solveTest() {
        int result = Solution.birthdayCakeCandles(4, new int[]{3, 2, 1, 3});

        assertEquals(2, result);

        result = Solution.birthdayCakeCandles(5, new int[]{3, 2, 1, 3, 3});

        assertEquals(3, result);

        result = Solution.birthdayCakeCandles(6, new int[]{3, 12, 1, 11, 4, 3});

        assertEquals(1, result);

        result = Solution.birthdayCakeCandles(7, new int[]{3, 12, 1, 11, 4, 3, 12});

        assertEquals(2, result);

        result = Solution.birthdayCakeCandles(7, new int[]{3, 12, 14, 11, 14, 3, 14});

        assertEquals(3, result);
    }
}