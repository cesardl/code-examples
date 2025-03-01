package com.bbva.reducedstring;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created for examples on 01/03/2025.
 *
 * @author Cesardl
 */
public class ResultTest {

    @Test
    public void sample1() {
        String r = Result.superReducedString("aaabccddd");
        assertEquals("abd", r);
    }

    @Test
    public void sample2() {
        String r = Result.superReducedString("aa");
        assertEquals("Empty String", r);
    }

    @Test
    public void sample3() {
        String r = Result.superReducedString("baab");
        assertEquals("Empty String", r);
    }
}