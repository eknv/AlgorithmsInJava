package com.eknv.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if the given str can be converted
 * to a string with k repeated substrings of length k
 * after replacing k characters.
 * <p>
 * Input: str = "bdac",  k = 2
 * Output: True
 * We can either replace "bd" with "ac" or
 * "ac" with "bd".
 * <p>
 * Input: str = "abcbedabcabc",  k = 3
 * Output: True
 * Replace "bed" with "abc" so that the
 * whole string becomes repetition of "abc".
 * <p>
 * Input: str = "bcacc", k = 3
 * Output: False
 * k doesn't divide_conquer string length i.e. 5%3 != 0
 * <p>
 * Input: str = "bcacbcac", k = 2
 * Output: False
 * <p>
 * Input: str = "bcdbcdabcedcbcd", k = 3
 * Output: False
 * <p>
 */
public class StringAsRepeatedSubstrings {

    private StringAsRepeatedSubstrings() {
    }

    public static boolean checkString(String str, int k) {

        /**
         * Length of string must be
         * a multiple of k
         */
        int n = str.length();
        if (n % k != 0) {
            return false;
        }

        /**
         * Map to store strings of length k and their counts
         */
        Map<String, Integer> uniqueSubstrings = new HashMap<>();
        for (int i = 0; i < n - k; i += k) {
            String substring = str.substring(i, i + k);
            uniqueSubstrings.compute(substring, (key, value) -> value == null ? 1 : ++value);
        }


        /**
         * If string is already a repition
         * of k substrings, return true.
         */
        if (uniqueSubstrings.size() == 1) {
            return true;
        }


        /**
         * If number of distinct substrings is not 2,
         * then not possible to replace a string.
         */
        if (uniqueSubstrings.size() != 2) {
            return false;
        }

        int value = uniqueSubstrings.values().iterator().next();

        /**
         * One of the two distinct must appear exactly once.
         * - either the first entry appears once
         * - or it appears n/k-1 times to make other substring appear once
         */
        return value == (n / k - 1) || value == 1;
    }

}

