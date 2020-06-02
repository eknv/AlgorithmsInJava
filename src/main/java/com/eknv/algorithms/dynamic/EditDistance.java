package com.eknv.algorithms.dynamic;


/**
 * Write a methode that calculates the "Edit Distance" between two given strings
 * <p>
 * Edit distance is a metric to quantify how dissimilar two strings are to one another
 * by counting the minimum number of operations required to transform one string into the other
 */
public class EditDistance {

    private EditDistance() {
    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        } else if (y <= x && y <= z) {
            return y;
        } else {
            return z;
        }
    }

    public static int calculate(String str1, String str2) {

        int[][] dpTable = new int[str1.length() + 1][str2.length() + 1];

        for (int i1 = 0; i1 <= str1.length(); i1++) {
            dpTable[i1][0] = i1;
        }

        for (int i2 = 0; i2 <= str2.length(); i2++) {
            dpTable[0][i2] = i2;
        }

        for (int i1 = 1; i1 <= str1.length(); i1++) {
            for (int i2 = 1; i2 <= str2.length(); i2++) {
                if (str1.charAt(i1 - 1) == str2.charAt(i2 - 1)) {
                    dpTable[i1][i2] = dpTable[i1 - 1][i2 - 1];
                } else {

                    dpTable[i1][i2] = 1 + min(
                            /**
                             * replace one with the other (go one back from i1 and i2)
                             */
                            dpTable[i1 - 1][i2 - 1],
                            /**
                             * remove from str1 (go one back from i1)
                             */
                            dpTable[i1 - 1][i2],
                            /**
                             * insert to str1 (go one back from i1+1 and i2)
                             */
                            dpTable[i1][i2 - 1]
                    );
                }
            }
        }

        return dpTable[str1.length()][str2.length()];
    }


}
