package com.bbva.strangeadvertising;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 02/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void testCase0() {
        int r = Result.viralAdvertising(3);
        assertEquals(9, r);
    }

    @Test
    public void testCase1() {
        int r = Result.viralAdvertising(4);
        assertEquals(15, r);
    }

    @Test
    public void testCase2() {
        int r = Result.viralAdvertising(5);
        assertEquals(24, r);
    }
}