package com.bbva.minmaxsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static long[] funct(List<Integer> arr) {
        Collections.sort(arr);
        long min = 0;
        long max = 0;
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            if (i == 0) {
                min = min + x;
            } else if (i == 4) {
                max = max + x;
            } else {
                min = min + x;
                max = max + x;
            }
        }

        return new long[]{min, max};
    }
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long[] r = funct(arr);

        System.out.println(r[0] + " " + r[1]);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
