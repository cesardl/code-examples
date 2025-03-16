package com.wu.mergetwosortedlinkedlists;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static List<Integer> listA = new LinkedList<>();
    static List<Integer> listB = new LinkedList<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        assert t >= 1 && t <= 10;
        int count = 1;
        while (count <= t) {
            listA.clear();
            listB.clear();
            // System.out.println("Test case: " + count + " de ");
            int n = in.nextInt();
            assert n >= 1 && n <= 1000;
            // System.out.println("Total of elements n in array: " + n);

            for (int i = 0; i < n; i++) {
                collect(in.nextInt(), listA);
            }

            int m = in.nextInt();
            assert m >= 1 && m <= 1000;
            // System.out.println("Total of elements n in array: " + m);

            for (int i = 0; i < m; i++) {
                collect(in.nextInt(), listB);
            }

            // System.out.println(listA);
            // System.out.println(listB);

            merge(listA, listB);

            count++;
            System.out.println();
        }
    }

    static void collect(int v, List<Integer> d) {
        d.add(v);
    }

    static void merge(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new LinkedList<>();
        result.addAll(listA.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        result.addAll(listB.stream().filter(Objects::nonNull).collect(Collectors.toList()));

        Collections.sort(result);

        for (Integer x : result) {
            System.out.print(x + " ");
        }
    }
}