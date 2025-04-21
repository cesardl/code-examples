package com.wu.insertionsort1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created for examples on 20/04/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void exerciseTest0() {
        Result.insertionSort1(5, Arrays.asList(1, 2, 4, 5, 3));

        assertTrue(true);
    }

    @Test
    public void exerciseTest1() {
        Result.insertionSort1(5, Arrays.asList(2, 4, 6, 8, 3));

        assertTrue(true);
    }

    @Test
    public void testCase1() {
        Result.insertionSort1(14, Arrays.asList(1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23));

        assertTrue(true);
    }

    @Test
    public void testCase2() {
        Result.insertionSort1(10, Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1));

        assertTrue(true);
    }
}
