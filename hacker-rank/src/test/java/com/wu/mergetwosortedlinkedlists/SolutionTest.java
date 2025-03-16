package com.wu.mergetwosortedlinkedlists;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created for examples on 16/03/2025.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void testCase0() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/merge-two-sorted-linked-lists/input02.txt"));
        int t = Integer.parseInt(lines.get(0));
        System.out.println("Test case: " + t);

        int n = Integer.parseInt(lines.get(1));
        System.out.println("Total of elements n in array: " + n);

        for (int i = 2; i < n + 2; i++) {
            int v = Integer.parseInt(lines.get(i));
            Solution.collect(v, Solution.listA);
        }
        System.out.println(Solution.listA.size() + " :: " + Solution.listA);

        int m = Integer.parseInt(lines.get(n + 2)); // t + n + m positions
        System.out.println("Total of elements n in array: " + m);
        for (int i = n + 3; i < m + n + 3; i++) {
            int v = Integer.parseInt(lines.get(i));
            Solution.collect(v, Solution.listB);
        }
        System.out.println(Solution.listB.size() + " :: " + Solution.listB);

        Solution.merge(Solution.listA, Solution.listB);
    }
}