package com.bbva.betweentwosets;

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
    public void testCase0() {
        int r = Result.getTotalX(Arrays.asList(2, 6), Arrays.asList(24, 36));
        assertEquals(2, r);
    }

    @Test
    public void testCase1() {
        int r = Result.getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96));
        assertEquals(3, r);
    }
}