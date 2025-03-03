package com.bbva.designerpdfviewer;

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
    public void testCase0() {
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 1, 1, 5, 5, 1, 5, 2, 5, 5, 5, 5, 5, 5);
        String word = "torn";
        int r = Result.designerPdfViewer(h, word);
        assertEquals(r, 8);
    }

    @Test
    public void testCase1() {
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word = "abc";
        int r = Result.designerPdfViewer(h, word);
        assertEquals(r, 9);
    }

    @Test
    public void testCase2() {
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
        String word = "zaba";
        int r = Result.designerPdfViewer(h, word);
        assertEquals(r, 28);
    }
}