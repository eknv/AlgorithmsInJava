package com.eknv.algorithms.dynamic;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * <p>
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 */
public class EqualWithExactlyOneCharSwap {


    private EqualWithExactlyOneCharSwap() {
    }


    public static boolean calculate(String a, String b) {

        if (a == null || b == null) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        if (a.length() == 0 && b.length() == 0) {
            return false;
        }

        boolean[] dpArray = new boolean[a.length() + 1];

        dpArray[0] = true;
        dpArray[1] = a.charAt(0) == b.charAt(0);
        int numberOfSwaps = 0;

        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                dpArray[i + 1] = dpArray[i];
            } else if (a.charAt(i - 1) == b.charAt(i) && a.charAt(i) == b.charAt(i - 1)) {
                dpArray[i + 1] = dpArray[i - 1];
                numberOfSwaps++;
            }

            if (numberOfSwaps > 1) {
                return false;
            }

        }

        return dpArray[dpArray.length - 1] && numberOfSwaps == 1;
    }


}
