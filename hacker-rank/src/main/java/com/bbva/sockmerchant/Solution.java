package com.bbva.sockmerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        if (n != ar.length) {
            throw new IllegalArgumentException();
        }

        int pairs = 0;
        List<Integer> stack = new ArrayList<>();
        for (int sock : ar) {
            if (sock > 100 || sock < 0) {
                throw new IllegalArgumentException();
            }
            if (!stack.isEmpty() && stack.contains(sock)) {
                stack.removeIf(s -> s == sock);
                pairs++;

            } else {
                stack.add(sock);
            }
        }

        return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

