package com.bbva.bonappetit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 02/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void testCase1() {
        String r = Result.funct(new ArrayList<>(Arrays.asList(3, 10, 2, 9)), 1, 12);
        assertEquals("5", r);
    }

    @Test
    public void testCase2() {
        String r = Result.funct(new ArrayList<>(Arrays.asList(3, 10, 2, 9)), 1, 7);
        assertEquals("Bon Appetit", r);
    }
}