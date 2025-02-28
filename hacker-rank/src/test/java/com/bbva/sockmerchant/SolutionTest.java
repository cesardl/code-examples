package com.bbva.sockmerchant;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void sockMerchantTest() {
        int result = Solution.sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        assertEquals(3, result);

        result = Solution.sockMerchant(10, new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3});
        assertEquals(4, result);

        result = Solution.sockMerchant(9, new int[]{10, 10, 10, 10, 10, 10, 50, 50, 40});
        assertEquals(4, result);

        result = Solution.sockMerchant(10, new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
        assertEquals(0, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sockMerchantWrongSockTest() {
        Solution.sockMerchant(1, new int[]{101});
    }
}