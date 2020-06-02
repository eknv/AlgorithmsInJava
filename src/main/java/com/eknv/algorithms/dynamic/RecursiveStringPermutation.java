package com.eknv.algorithms.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a recursive method for generating all permutations of an input string.
 * Return them as a set.
 * <p>
 * Don't worry about time or space complexity — if we wanted efficiency we'd write an iterative version.
 * <p>
 * To start, assume every character in the input string is unique.
 * <p>
 * Your method can have loops—it just needs to also be recursive.
 */
public class RecursiveStringPermutation {

    private RecursiveStringPermutation() {
    }

    public static Set<String> getPermutations(String inputString) {

        Set<String> permutations = new HashSet<>();

        if (inputString == null) {
            return permutations;
        }

        if (inputString.length() == 0) {
            permutations.add(inputString);
            return permutations;
        }

        if (inputString.length() == 1) {
            permutations.add(inputString);
            return permutations;
        }

        Set<String> previousPermutations = getPermutations(inputString.substring(0, inputString.length() - 1));

        char lastChar = inputString.charAt(inputString.length() - 1);

        for (String permutation : previousPermutations) {
            permutations.addAll(insertCharInString(permutation, lastChar));
        }

        return permutations;
    }

    private static Set<String> insertCharInString(String inputString, char c) {

        Set<String> permutations = new HashSet<>();

        if (inputString == null) {
            return permutations;
        }


        for (int i = 0; i <= inputString.length(); i++) {

            String permutation = new StringBuilder().append(inputString, 0, i)
                    .append(c)
                    .append(inputString.substring(i)).toString();
            permutations.add(permutation);
        }

        return permutations;
    }

}