package com.bbva.divisiblesumpairs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 08/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void sampleTest0() {
        int r = Result.divisibleSumPairs(6, 5, Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(3, r);
    }

    @Test
    public void sampleTest1() {
        int r = Result.divisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2));
        assertEquals(5, r);
    }
}