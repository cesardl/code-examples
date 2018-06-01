package com.bbva.grading;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solveTest() {
        int[] result = Solution.solve(new int[]{73, 67, 38, 33});

        assertEquals(75, result[0]);
        assertEquals(67, result[1]);
        assertEquals(40, result[2]);
        assertEquals(33, result[3]);

        result = Solution.solve(new int[]{4, 5, 37, 33});

        assertEquals(4, result[0]);
        assertEquals(5, result[1]);
        assertEquals(37, result[2]);
        assertEquals(33, result[3]);

        result = Solution.solve(new int[]{10, 15, 20, 25, 30, 35, 40});

        assertEquals(10, result[0]);
        assertEquals(15, result[1]);
        assertEquals(20, result[2]);
        assertEquals(25, result[3]);
        assertEquals(30, result[4]);
        assertEquals(35, result[5]);
        assertEquals(40, result[6]);
    }
}