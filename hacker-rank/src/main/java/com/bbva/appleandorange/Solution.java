package com.bbva.appleandorange;

import java.util.Scanner;

/**
 * Created on 14/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static int solve(int s, int t, int origin, int[] fruits) {
        int count = 0;
        for (int fruit : fruits) {
            int point = origin + fruit;
            if (point >= s && point <= t) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }

        assert a < s && s < t && t < b;

        System.out.println(solve(s, t, a, apple));
        System.out.println(solve(s, t, b, orange));
    }
}
