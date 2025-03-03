package com.bbva.breakingbestandworstrecords;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 02/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void testCase() {
        List<Integer> results = Result.breakingRecords(Arrays.asList(12, 24, 10, 24));
        assertEquals(1, results.get(0).intValue());
        assertEquals(1, results.get(1).intValue());
    }

    @Test
    public void testCase0() {
        List<Integer> results = Result.breakingRecords(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1));
        assertEquals(2, results.get(0).intValue());
        assertEquals(4, results.get(1).intValue());
    }

    @Test
    public void testCase1() {
        List<Integer> results = Result.breakingRecords(Arrays.asList(3, 4, 21, 36, 10, 28, 35, 5, 24, 42));
        assertEquals(4, results.get(0).intValue());
        assertEquals(0, results.get(1).intValue());
    }
}