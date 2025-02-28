package com.bbva.countingvalleys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void countingValleysTest() {
        String path = "UDDDUDUU";
        int result = Solution.countingValleys(path.length(), path);
        assertEquals(1, result);

        path = "UUDUDDDU";
        result = Solution.countingValleys(path.length(), path);
        assertEquals(1, result);

        path = "DDDUDUUUUUUUDDDDDDUU";
        result = Solution.countingValleys(path.length(), path);
        assertEquals(2, result);

        path = "DDUUDDUDUUUD";
        result = Solution.countingValleys(path.length(), path);
        assertEquals(2, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void countingValleysWrongPathTest() {
        Solution.countingValleys(8, "AUDDDUDUU");
    }

    @Test(expected = IllegalStateException.class)
    public void countingValleysContinueWalkingTest() {
        String path = "DDDUDUUUUUUUDDDDDDU";
        Solution.countingValleys(path.length(), path);
    }
}