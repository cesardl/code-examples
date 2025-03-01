package com.bbva.kangaroo;

import java.io.*;

/**
 * Created on 15/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        int x = (v2 - v1);
        if (x == 0) {
            return "NO";
        }
        float n = (x1 - x2) / x;
        int r = (x1 - x2) % x;
        System.out.println(n + " - " + r);
        if (r == 0 && n > 0) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
