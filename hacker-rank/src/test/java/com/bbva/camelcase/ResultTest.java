package com.bbva.camelcase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created for examples on 02/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void testCase1() {
        String s = "saveChangesInTheEditor";
        int r = Result.camelcase(s);
        assertEquals(r, 5);
    }
}