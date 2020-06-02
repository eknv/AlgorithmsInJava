package com.eknv.algorithms.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * You're working with an intern that keeps coming to you with JavaScript code that won't run
 * because the braces, brackets, and parentheses are off. To save you both some time,
 * you decide to write a braces/brackets/parentheses validator.
 * <p>
 * Let's say:
 * <p>
 * '(', '{', '[' are called "openers."
 * ')', '}', ']' are called "closers."
 * <p>
 * Write an efficient method that tells us whether or not an input string's openers and closers are properly nested.
 * <p>
 * Examples:
 * <p>
 * "{ [ ] ( ) }" should return true
 * "{ [ ( ] ) }" should return false
 * "{ [ }" should return false
 */
public class BracketValidator {

    private BracketValidator() {
    }

    public static boolean calculate(String code) {

        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> closingToOpening = new HashMap<>();
        closingToOpening.put(')', '(');
        closingToOpening.put(']', '[');
        closingToOpening.put('}', '{');

        for (int i = 0; i < code.length(); i++) {
            char currentChar = code.charAt(i);

            /**
             * if it is a closing character
             */
            if (closingToOpening.values().contains(currentChar)) {
                stack.push(currentChar);
            }

            /**
             * if it is a closing parenthesis and not counter-part could be found
             */
            if (closingToOpening.containsKey(currentChar)
                    && !counterPartMatch(stack, closingToOpening, currentChar)) {
                return false;
            }

        }

        /**
         * in case there are still opening braces present is the stack, return false
         */
        return stack.isEmpty();
    }

    /**
     * @return true if the counter part brace is at the top of the stack, otherwise false
     */
    private static boolean counterPartMatch(Deque<Character> stack,
                                            Map<Character, Character> closingToOpening,
                                            char c) {
        Character openingChar = closingToOpening.get(c);
        if (stack.peek() == null || !stack.peek().equals(openingChar)) {
            return false;
        } else {
            stack.pop();
            return true;
        }
    }

}