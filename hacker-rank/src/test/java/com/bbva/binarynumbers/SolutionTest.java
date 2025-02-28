package com.bbva.binarynumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 03/01/2020.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void test1() {
        int r = Solution.binaryAndConsecutive(13);

        assertEquals(2, r);
    }

    @Test
    public void test2() {
        int r = Solution.binaryAndConsecutive(5);

        assertEquals(1, r);
    }

    @Test
    public void test3() {
        int r = Solution.binaryAndConsecutive(100);

        assertEquals(2, r);
    }

    @Test
    public void test4() {
        int r = Solution.binaryAndConsecutive(57);

        assertEquals(3, r);
    }
}
