package com.bbva.biggerisgreater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static final Logger LOG = LoggerFactory.getLogger(Solution.class);
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int index = 0;

        char x = w.charAt(index);
        char y = w.charAt(index + 1);

        if (x > y) {
            // swap
        }


        return "no answer";
    }

    public static void main(String[] args) throws IOException {
        System.getenv().forEach((k, v) -> LOG.info("{} -> {}", k, v));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
