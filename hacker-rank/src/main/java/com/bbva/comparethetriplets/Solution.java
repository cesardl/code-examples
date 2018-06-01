package com.bbva.comparethetriplets;

import java.util.Scanner;

/**
 * Created on 12/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        assert a0 >= 1 && a0 <= 100;
        assert a1 >= 1 && a1 <= 100;
        assert a2 >= 1 && a2 <= 100;
        assert b0 >= 1 && b0 <= 100;
        assert b1 >= 1 && b1 <= 100;
        assert b2 >= 1 && b2 <= 100;

        int alice = 0;
        int bob = 0;

        if (a0 > b0) {
            alice++;
        }
        if (a1 > b1) {
            alice++;
        }
        if (a2 > b2) {
            alice++;
        }
        if (a0 < b0) {
            bob++;
        }
        if (a1 < b1) {
            bob++;
        }
        if (a2 < b2) {
            bob++;
        }

        return new int[]{alice, bob};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
}
