package com.eknv.algorithms.stack_queue;

import org.springframework.util.Assert;

/**
 * Write a method that, given a sentence like the one above, along with the position of an opening parenthesis,
 * finds the corresponding closing parenthesis.
 * <p>
 * Example: if the example string above is input with the number 10 (position of the first parenthesis),
 * the output should be 79 (position of the last parenthesis).
 */
public class ParenthesisMatching {

    private ParenthesisMatching() {
    }

    public static int getClosingParen(String sentence, int openingParenIndex) {

        if (sentence == null
                || sentence.isEmpty()
                || openingParenIndex > sentence.length() - 1
                || sentence.charAt(openingParenIndex) != '(') {
            throw new IllegalArgumentException("The provided arguments are not valid");
        }

        int numberOfOpeningParenthsis = 0;

        for (int index = openingParenIndex; index < sentence.length(); index++) {
            if (sentence.charAt(index) == '(') {
                numberOfOpeningParenthsis++;
            } else if (sentence.charAt(index) == ')') {
                numberOfOpeningParenthsis--;
                if (numberOfOpeningParenthsis == 0) {
                    return index;
                }
            }
        }

        Assert.isTrue(false, "The closing parenthesis could not be found");

        return -1;
    }

}