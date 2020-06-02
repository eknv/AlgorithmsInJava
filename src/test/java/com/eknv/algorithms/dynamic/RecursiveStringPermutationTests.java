package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a recursive method for generating all permutations of an input string. Return them as a set.
 * <p>
 * Don't worry about time or space complexity—if we wanted efficiency we'd write an iterative version.
 * <p>
 * To start, assume every character in the input string is unique.
 * <p>
 * Your method can have loops—it just needs to also be recursive.
 */
public class RecursiveStringPermutationTests {


    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = RecursiveStringPermutation.getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = RecursiveStringPermutation.getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = RecursiveStringPermutation.getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                "cab", "cba"));
        final Set<String> actual = RecursiveStringPermutation.getPermutations("abc");
        assertEquals(expected, actual);
    }
    
}