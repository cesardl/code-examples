package com.bbva;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created for examples on 17/02/2021.
 *
 * @author Cesardl
 */
public class Solution {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        sorter(s);

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

    static void sorter(final String[] s) {
        BigDecimal[] r = new BigDecimal[s.length];

        for (int i = 0; i < s.length; i++) {
            r[i] = new BigDecimal(s[i]);
        }
        Arrays.stream(r).forEach(System.out::println);
    }
}
