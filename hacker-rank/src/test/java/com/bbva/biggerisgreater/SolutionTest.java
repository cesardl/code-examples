package com.bbva.biggerisgreater;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 25/12/2019.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void scenario1() {
        String result = Solution.biggerIsGreater("ab");
        assertEquals("ba", result);
    }

    @Test
    public void scenario2() {
        String result = Solution.biggerIsGreater("bb");
        assertEquals("no answer", result);
    }

    @Test
    public void scenario3() {
        String result = Solution.biggerIsGreater("hefg");
        assertEquals("hegf", result);
    }

    @Test
    public void scenario4() {
        String result = Solution.biggerIsGreater("dhck");
        assertEquals("dhkc", result);
    }

    @Test
    public void scenario5() {
        String result = Solution.biggerIsGreater("dkhc");
        assertEquals("hcdk", result);
    }

    @Test
    public void scenario6() {
        String result = Solution.biggerIsGreater("lmno");
        assertEquals("lmon", result);
    }

    @Test
    public void scenario7() {
        String result = Solution.biggerIsGreater("dcba");
        assertEquals("no answer", result);
    }

    @Test
    public void scenario8() {
        String result = Solution.biggerIsGreater("dcbb");
        assertEquals("no answer", result);
    }

    @Test
    public void scenario9() {
        String result = Solution.biggerIsGreater("abdc");
        assertEquals("acbd", result);
    }

    @Test
    public void scenario10() {
        String result = Solution.biggerIsGreater("abcd");
        assertEquals("abdc", result);
    }

    @Test
    public void scenario11() {
        String result = Solution.biggerIsGreater("fedcbabcd");
        assertEquals("fedcbabdc", result);
    }
}
