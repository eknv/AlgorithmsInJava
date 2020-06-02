package com.eknv.algorithms.dynamic;


public class LongestPalindromicSubsequence {

    private LongestPalindromicSubsequence() {
    }

    public static int calculate(String seq) {

        int n = seq.length();

        int[][] matrix = new int[n][n];


        /**
         * all the substrings with a length of 1 have a palindrom of 1
         */
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }

        for (int range = 2; range <= n; range++) {

            for (int startIndex = 0; startIndex < n - range + 1; startIndex++) {

                int endIndex = startIndex + range - 1;

                if (seq.charAt(startIndex) == seq.charAt(endIndex)) {

                    matrix[startIndex][endIndex] = 2 + (range == 2 ? 0 : matrix[startIndex + 1][endIndex - 1]);

                } else {

                    matrix[startIndex][endIndex] = Math.max(
                            matrix[startIndex + 1][endIndex],
                            matrix[startIndex][endIndex - 1]
                    );

                }

            }

        }


        /**
         * return the calculated value between the indexes 0 and n-1 which is the whole length of the given string
         */
        return matrix[0][n - 1];

    }

}

