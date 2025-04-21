package com.wu.insertionsort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int index = n - 1;
        int value = arr.get(index);

        boolean stop = false;
        for (int i = index - 1; i >= 0 && !stop; i--) {
            int x = arr.get(i);
            // System.out.println("Index: " + i + " | comparing " + x + " > " + value );

            int r;
            if (x > value) {
                r = x;
            } else {
                r = value;
                stop = true;
            }
            arr.set(i + 1, r);
            for (int j = 0; j < arr.size(); j++) {
                if (j == i + 1) {
                    System.out.print(r + " ");
                } else {
                    System.out.print(arr.get(j) + " ");
                }
            }
            System.out.println();
        }
        // System.out.println(" | stopped? " + stop);
        if (!stop) {
            arr.set(0, value);
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
