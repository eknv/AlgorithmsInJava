package com.eknv.algorithms.dynamic;

/**
 * the shortest character sequence that contains the given two strings
 * note that the of the characters in both strings should be kept in the super-sequence
 */
public class ShortestCommonSuperSequenceLength {

    private ShortestCommonSuperSequenceLength() {
    }

    public static int calculate(String text1, String text2) {

        int[][] matrix = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {

            for (int j = 0; j <= text2.length(); j++) {

                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + 1;
                }

            }

        }

        return matrix[text1.length()][text2.length()];
    }

}
