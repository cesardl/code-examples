package com.bbva.grading;

import java.util.Scanner;

/**
 * Created on 13/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static int[] solve(int[] grades) {
        int[] newGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];

            int quotient = grade / 5;

            int next = (grade % 5 > 0 ? quotient + 1 : quotient) * 5;

            int newGrade = grade;
            if (newGrade >= 38 && next - grade < 3) {
                newGrade = next;
            }
            newGrades[i] = newGrade;
        }
        return newGrades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
