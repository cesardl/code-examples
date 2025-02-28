package com.bbva.mergearray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void test() {
        int[] merge = Solution.merge(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merge);

        merge = Solution.merge(new int[]{5, 7, 8}, new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8}, merge);

        merge = Solution.merge(new int[]{1, 2, 4}, new int[]{2, 5, 6});
        assertArrayEquals(new int[]{1, 2, 2, 4, 5, 6}, merge);
    }
}
