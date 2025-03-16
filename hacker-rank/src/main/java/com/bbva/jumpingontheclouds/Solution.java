package com.bbva.jumpingontheclouds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 * @see <a href="https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem">Jumping on the Clouds</a>
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        List<Set<Integer>> results = new ArrayList<>();
        Set<Integer> t1 = new HashSet<>(), t2 = new HashSet<>();
        // First step
        if (isCumulusNimbus(c[0] + 1)) {
            t1.add(c[0]);
        }
        if (isCumulusNimbus(c[0] + 2)) {
            t2.add(c[0]);
        }


        int nextStep1 = 0;
        int nextStep2 = 0;

        for (int i = 1; i < c.length; i++) {
            nextStep1 = i + 1; // next index cloud to jump
            nextStep2 = i + 2;

            if (isCumulusNimbus(c[nextStep1])) {
                if (t1 == null) {
                    //t1
                    t1.add(c[i]);
                    results.add(t1);
                }
            }
            if (isCumulusNimbus(c[nextStep2])) {
                if (t2 == null) {
                    t2 = new HashSet<>();
                    t2.add(c[i]);
                    results.add(t2);
                }
            }
        }

        return -1;
    }

    private static void game(int v, Set<Integer> way) {

    }

    private static boolean isCumulusNimbus(int value) {
        return value == 0;
    }

    private static Set<Integer> makeWay(boolean isNew, Set<Integer> way, int v) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
