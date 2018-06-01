package com.bbva.birthdaycakecandles;

import java.util.Scanner;

/**
 * Created on 12/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        int max = ar[0];

        int count = 1;
        for (int i = 1; i < ar.length; i++) {
            if (max < ar[i]) {
                max = ar[i];
                count = 1;
            } else if (max == ar[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
