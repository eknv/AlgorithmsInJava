package com.eknv.algorithms.dynamic;


public class LongestPalindromicSubstring {

    private LongestPalindromicSubstring() {
    }

    public static String calculate(String seq) {

        int n = seq.length();

        int[][] matrix = new int[n][n];

        /**
         * all the substrings with a length of 1 have a palindrom of 1
         */
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }

        int maxStartIndex = 1;
        int maxEndIndex = 1;

        for (int range = 2; range <= n; range++) {
            for (int startIndex = 0; startIndex < n - range + 1; startIndex++) {
                int endIndex = startIndex + range - 1;
                if (seq.charAt(startIndex) != seq.charAt(endIndex)) {
                    continue;
                }
                if (range == 2) {
                    matrix[startIndex][endIndex] = 2;
                } else if (matrix[startIndex + 1][endIndex - 1] > 0) {
                    matrix[startIndex][endIndex] = 2 + matrix[startIndex + 1][endIndex - 1];
                }

                if (matrix[startIndex][endIndex] > matrix[maxStartIndex][maxEndIndex]) {
                    maxStartIndex = startIndex;
                    maxEndIndex = endIndex;
                }

            }
        }

        /**
         * return the calculated value between the indexes 0 and n-1 which is the whole length of the given string
         */
        return seq.substring(maxStartIndex, maxEndIndex + 1);
    }

}

