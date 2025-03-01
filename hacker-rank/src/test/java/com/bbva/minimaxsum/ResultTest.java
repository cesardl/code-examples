package com.bbva.minimaxsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created for examples on 01/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void sample1() {
        assertArrayEquals(new long[]{10, 14}, Result.funct(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void sample2() {
        assertArrayEquals(new long[]{299, 9271}, Result.funct(Arrays.asList(7, 69, 2, 221, 8974)));
    }
}