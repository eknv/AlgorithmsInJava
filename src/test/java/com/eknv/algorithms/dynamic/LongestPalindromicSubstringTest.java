package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * the longest palindromic substring test
 */
public class LongestPalindromicSubstringTest {

    @Test
    void test1() {

        assertEquals("kjfjk", LongestPalindromicSubstring.calculate("ljlakjfjkqu4romvy,n4"));
        assertEquals("eknvvnke", LongestPalindromicSubstring.calculate("eknvvnke"));
        assertEquals("eknv1vnke", LongestPalindromicSubstring.calculate("eknv1vnke"));
        assertEquals("bb", LongestPalindromicSubstring.calculate("cbbd"));
        assertEquals("bab", LongestPalindromicSubstring.calculate("babad"));

    }


}
