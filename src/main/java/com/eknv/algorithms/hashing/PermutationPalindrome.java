package com.eknv.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an efficient method that checks whether any permutation of an input string is a palindrome.
 * <p>
 * You can assume the input string only contains lowercase letters.
 * <p>
 * Examples:
 * <p>
 * "civic" should return true
 * "ivicc" should return true
 * "civil" should return false
 * "livci" should return false
 * <p>
 * "But 'ivicc' isn't a palindrome!"
 * We're asking if any permutation of the string is a palindrome.
 */
public class PermutationPalindrome {


    private PermutationPalindrome() {
    }

    public static boolean calculate(String inputString) {

        if (inputString.length() == 0) {
            return true;
        }

        // check if any permutation of the input is a palindrome

        Set<Character> characters = new HashSet<>();
        char[] chars = inputString.toCharArray();
        for (char c : chars) {
            if (characters.contains(c)) {
                characters.remove((Object) c);
            } else {
                characters.add(c);
            }
        }

        return characters.isEmpty() || characters.size() == 1;
    }

}
