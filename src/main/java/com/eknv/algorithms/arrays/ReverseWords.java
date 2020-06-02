package com.eknv.algorithms.arrays;

/**
 * You're working on a secret team solving coded transmissions.
 * <p>
 * Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault.
 * The message has been mostly deciphered, but all the words are backward! Your colleagues have handed off the last step to you.
 * <p>
 * Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words in place.
 * <p>
 * Why an array of characters instead of a string?
 * <p>
 * The goal of this question is to practice manipulating strings in place. Since we're modifying the message, we need a mutable
 * type like an array, instead of Java's immutable strings.
 * <p>
 * For example:
 * <p>
 * char[] message = { 'c', 'a', 'k', 'e', ' ',
 * 'p', 'o', 'u', 'n', 'd', ' ',
 * 's', 't', 'e', 'a', 'l' };
 * <p>
 * reverseWords(message);
 * <p>
 * System.out.println(message);
 * // prints: "steal pound cake"
 * <p>
 * When writing your method, assume the message contains only letters and spaces, and all words are separated by one space.
 */
public class ReverseWords {

    private ReverseWords() {
    }

    public static void reverseWords(char[] message) {

        // decode the message by reversing the words
        reverseCharacter(message, 0, message.length - 1);

        int startIndex = 0;
        for (int i = 0; i < message.length; i++) {
            if (i == message.length - 1 || message[i + 1] == ' ') {
                reverseCharacter(message, startIndex, i);
                startIndex = i + 2;
            }
        }

    }


    public static void reverseCharacter(char[] message, int start, int end) {


        while (start < end) {
            char temp = message[start];
            message[start] = message[end];
            message[end] = temp;
            start++;
            end--;
        }


    }


}
