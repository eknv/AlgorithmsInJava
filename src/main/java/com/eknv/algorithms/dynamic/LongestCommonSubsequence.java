package com.eknv.algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * calculate the characters that occur in both strings in the given orders
 */
public class LongestCommonSubsequence {

    private LongestCommonSubsequence() {
    }

    public static String calculate(String text1, String text2) {


        // Build the dp table
        int[][] matrix = new int[text1.length() + 1][text2.length() + 1];

        List<Character> list = new ArrayList<>();

        for (int i = 0; i <= text1.length(); i++) {

            for (int j = 0; j <= text2.length(); j++) {

                // if one of the strings is empty, then there cannot be any overlapping
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    list.add(text1.charAt(i - 1));
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

            }

        }

        StringBuilder sb = new StringBuilder();
        list.stream().forEach(sb::append);

        return sb.toString();
    }

}
