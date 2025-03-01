package com.bbva.reducedstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here
        String[] strSplit = s.split("");

        // Now convert string into ArrayList
        ArrayList<String> ss = new ArrayList<>(
                Arrays.asList(strSplit));
        boolean endOfString = false;

        System.out.println(ss);
        while (!endOfString) {

            int cursor = 0;
            int limit = ss.size() - 1;
            boolean oper = false;

            while (cursor < limit && !oper) {
                String x1 = ss.get(cursor);
                String x2 = ss.get(cursor + 1);
                System.out.println(cursor + ": " + x1 + " == " + x2 + "?");
                if (x1.equals(x2)) {
                    ss.remove(cursor + 1);
                    ss.remove(cursor);
                    oper = true;

                    System.out.println("#### OPER : " + ss + " -- " + ss.size());
                }
                cursor++;
            }
            System.out.println("llegue al final? " + cursor + " == " + limit);
            if (cursor == limit) {
                endOfString = true;
            }
        }

        if (ss.isEmpty()) {
            return "Empty String";
        } else {
            StringBuilder sb = new StringBuilder();
            ss.forEach(s1 -> sb.append(s1));
            return sb.toString();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
