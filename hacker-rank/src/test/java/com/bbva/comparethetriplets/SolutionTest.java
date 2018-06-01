package com.bbva.comparethetriplets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solveTest() {
        int[] result = Solution.solve(5, 6, 7, 3, 6, 10);

        assertEquals(1, result[0]);
        assertEquals(1, result[1]);

        result = Solution.solve(6, 8, 12, 7, 9, 15);

        assertEquals(0, result[0]);
        assertEquals(3, result[1]);
    }
}