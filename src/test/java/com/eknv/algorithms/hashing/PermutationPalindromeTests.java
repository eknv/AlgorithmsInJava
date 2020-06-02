package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationPalindromeTests {


    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = PermutationPalindrome.calculate("aabcbcd");
        assertTrue(result);
    }


    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = PermutationPalindrome.calculate("aabccbdd");
        assertTrue(result);
    }


    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = PermutationPalindrome.calculate("aabcd");
        assertFalse(result);
    }


    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = PermutationPalindrome.calculate("aabbcd");
        assertFalse(result);
    }


    @Test
    public void emptyStringTest() {
        final boolean result = PermutationPalindrome.calculate("");
        assertTrue(result);
    }


    @Test
    public void oneCharacterStringTest() {
        final boolean result = PermutationPalindrome.calculate("a");
        assertTrue(result);
    }


}