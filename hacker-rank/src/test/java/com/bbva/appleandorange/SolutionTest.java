package com.bbva.appleandorange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SolutionTest {

    @Test
    public void test() {
        int s = 7;
        int t = 11;

        int result = Solution.solve(s, t, 5, new int[]{-2, 2, 1});
        assertEquals(1, result);

        result = Solution.solve(s, t, 5, new int[]{2, 3, 4, 5, 6});
        assertEquals(5, result);

        result = Solution.solve(s, t, 5, new int[]{-2, -1, 0, 1});
        assertEquals(0, result);

        result = Solution.solve(s, t, 15, new int[]{5, -6});
        assertEquals(1, result);

        result = Solution.solve(s, t, 15, new int[]{-4, -5, -6, -7, -8});
        assertEquals(5, result);

        result = Solution.solve(s, t, 15, new int[]{-3, -2, -1, 0, 1});
        assertEquals(0, result);
    }

    @Test(expected = AssertionError.class)
    public void testFailed() {
        int s = 7;
        int t = 11;

        Solution.solve(s, t, 6, new int[]{-2, 2, 1});
        fail();
    }
}