package com.eknv.algorithms.dynamic;

public class LongestCommonSubstring {

    private LongestCommonSubstring() {
    }

    public static String calculate(String text1, String text2) {

        int[][] matrix = new int[text1.length()][text2.length()];
        int maxLengthX = 0;
        int maxLengthY = 0;

        for (int i = 0; i < text1.length(); i++) {

            for (int j = 0; j < text2.length(); j++) {

                if (text1.charAt(i) != text2.charAt(j)) {
                    continue;
                }

                matrix[i][j] = ((i == 0 || j == 0) ? 0 : matrix[i - 1][j - 1]) + 1;

                /**
                 * capture the location of the last max
                 */
                if (matrix[i][j] > matrix[maxLengthX][maxLengthY]) {
                    maxLengthX = i;
                    maxLengthY = j;
                }


            }
        }

        int maxLength = matrix[maxLengthX][maxLengthY];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= maxLength; i++) {
            sb.append(text1.charAt(maxLengthX - maxLength + i));
        }

        return sb.toString();
    }

}
