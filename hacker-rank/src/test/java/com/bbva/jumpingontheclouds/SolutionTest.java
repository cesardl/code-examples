package com.bbva.jumpingontheclouds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void jumpingOnCloudsTest() {
        int result = Solution.jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});
        assertEquals(4, result);

        result = Solution.jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0});
        assertEquals(3, result);
    }
}