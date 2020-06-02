package com.eknv.algorithms.dynamic;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * <p>
 */

public class StringInterleaving {

    private StringInterleaving() {
    }


    public static boolean calculate(String str1, String str2, String strToCheck) {

        if (str1 == null || str2 == null || strToCheck == null) {
            throw new IllegalArgumentException("The string arguments cannot be null");
        }

        /**
         * sum of the lengths should be the same
         */
        if (str1.length() + str2.length() != strToCheck.length()) {
            return false;
        }

        boolean[][] matrix = new boolean[str1.length() + 1][str2.length() + 1];

        /**
         * base cases
         */

        /**
         * if both strings are empty, since the size check already passed, then the strToCheck will also be empty
         */
        matrix[0][0] = true;

        /**
         * if str2 is empty, then we just check the str1
         */
        for (int i = 1; i <= str1.length(); i++) {
            matrix[i][0] = str1.charAt(i - 1) == strToCheck.charAt(i - 1) && matrix[i - 1][0];
        }

        /**
         * if str1 is empty, then we just check the str2
         */
        for (int j = 1; j <= str2.length(); j++) {
            matrix[0][j] = str2.charAt(j - 1) == strToCheck.charAt(j - 1) && matrix[0][j - 1];
        }

        for (int i = 1; i <= str1.length(); i++) {

            for (int j = 1; j <= str2.length(); j++) {

                /**
                 * if the letter of 'str1' and 'strToCheck' match, we take whatever is matched till i-1
                 */
                matrix[i][j] = str1.charAt(i - 1) == strToCheck.charAt(i - 1 + j) && matrix[i - 1][j];

                /**
                 * we do the same check also with the str2, note the '|='
                 * if the letter of 'str2' and 'strToCheck' match, we take whatever is matched till j-1
                 */
                matrix[i][j] |= str2.charAt(j - 1) == strToCheck.charAt(j - 1 + i) && matrix[i][j - 1];

            }
        }

        return matrix[str1.length()][str2.length()];
    }

}
