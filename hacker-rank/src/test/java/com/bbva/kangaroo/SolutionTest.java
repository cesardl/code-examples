package com.bbva.kangaroo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solveTest() {
        String result = Solution.kangaroo(0, 3, 4, 2);

        assertEquals("YES", result);

        result = Solution.kangaroo(0, 2, 5, 3);

        assertEquals("NO", result);
    }

    @Test
    public void solveTest1() {
        String result = Solution.kangaroo(43, 2, 70, 2);
        assertEquals("NO", result);
    }
}