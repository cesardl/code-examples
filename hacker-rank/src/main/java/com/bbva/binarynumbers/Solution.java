package com.bbva.binarynumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int binaryAndConsecutive(int n) {
        List<Integer> binary = new ArrayList<>();

        do {
            int r = n % 2;
            binary.add(r);
            n = n / 2;
        } while (n >= 2);
        binary.add(n);
        List<Integer> counts = new ArrayList<>();
        int count = 0;

        for (Integer x : binary) {
            if (x == 1) {
                count++;
            } else {
                counts.add(count);
                count = 0;
            }
        }
        counts.add(count);
        return counts.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        System.out.println(binaryAndConsecutive(n));
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = scanner.next();
            int x = scanner.nextInt();

            System.out.println(complete(s1, x));
        }
        System.out.println("================================");
    }

    static String complete(String s1, int x) {
        int length = s1.length();
        for (int i = length; i < 15; i++) {
            s1 = s1.concat(" ");
        }

        String s2;
        if (x < 10) {
            s2 = "00".concat(String.valueOf(x));
        } else if (x < 100) {
            s2 = "0".concat(String.valueOf(x));
        } else {
            s2 = String.valueOf(x);
        }

        return String.format("%s%s", s1, s2);
    }
}
