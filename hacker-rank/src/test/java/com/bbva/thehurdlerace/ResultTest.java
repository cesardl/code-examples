package com.bbva.thehurdlerace;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 02/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void testCase0() {
        int r = Result.hurdleRace(1, Arrays.asList(1, 2, 3, 3, 2));
        assertEquals(2, r);
    }

    @Test
    public void testCase1() {
        int r = Result.hurdleRace(4, Arrays.asList(1, 6, 3, 5, 2));
        assertEquals(2, r);
    }

    @Test
    public void testCase2() {
        int r = Result.hurdleRace(7, Arrays.asList(2, 5, 4, 5, 2));
        assertEquals(0, r);
    }
}