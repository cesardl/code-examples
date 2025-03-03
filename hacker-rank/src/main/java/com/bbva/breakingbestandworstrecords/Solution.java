package com.bbva.breakingbestandworstrecords;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int cMax = 0;
        int cMin = 0;

        int vMax = scores.get(0);
        int vMin = scores.get(0);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(scores.get(0));
        for (int i = 1; i < scores.size(); i++) {
            System.out.println("( " + vMin + ", " + vMax + " ) || ( " + cMin + ", " + cMax + " )");
            int v = scores.get(i);
            tmp.add(v);

            int tMin = Collections.min(tmp);
            boolean b = false;
            if (tMin < vMin) {
                cMin++;
                b = true;
            }
            vMin = tMin;

            int tMax = Collections.max(tmp);
            if (tMax > vMax && !b) {
                cMax++;
            }
            vMax = tMax;
        }
        System.out.println("( " + vMin + ", " + vMax + " ) || ( " + cMin + ", " + cMax + " )");
        return Arrays.asList(cMax, cMin);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
