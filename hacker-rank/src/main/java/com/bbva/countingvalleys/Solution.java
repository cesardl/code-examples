package com.bbva.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created on 30/09/2018.
 *
 * @author Cesardl
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * It must return an integer that denotes the number of valleys Gary traversed.
     *
     * @param n the number of steps Gary takes
     * @param s a string describing his path
     * @return number of valleys
     */
    static int countingValleys(int n, String s) {
        if (n != s.length()) {
            throw new IllegalArgumentException();
        }

        int numberOfValleys = 0;
        int r = 0;
        char[] steps = s.toCharArray();
        State currentState = State.SEA_LEVEL;
        for (char step : steps) {
            if ('D' == step) {
                r -= 1;
            } else if ('U' == step) {
                r += 1;
            }
            if (r < 0) {
                currentState = State.DOWN;
            } else if (r > 0) {
                currentState = State.UP;
            } else {
                if (currentState == State.DOWN) {
                    numberOfValleys++;
                }
                currentState = State.SEA_LEVEL;
            }
        }

        if (r == 0) {
            return numberOfValleys;
        } else {
            throw new IllegalStateException("Does not end his hike");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    enum State {
        UP, SEA_LEVEL, DOWN
    }
}
