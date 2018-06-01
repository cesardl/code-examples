package com.bbva.kangaroo;

import java.util.Scanner;

/**
 * Created on 15/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        boolean stop = true;

        int step1 = x1 + v1;
        int step2 = x2 + v2;
        int p0 = step2 - step1;

        while (stop) {
            step1 = step1 + v1;
            step2 = step2 + v2;

            int p1 = step2 - step1;

            if (p1 >= p0) {
                return "NO";
            } else {
                stop = false;
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
