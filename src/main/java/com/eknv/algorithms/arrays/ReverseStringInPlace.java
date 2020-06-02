package com.eknv.algorithms.arrays;

/**
 * Write a method that takes an array of characters and reverses the letters in place.
 */
public class ReverseStringInPlace {

    private ReverseStringInPlace() {
    }

    public static void reverse(char[] arrayOfChars) {

        // reverse input array of characters in place

        if (arrayOfChars == null || arrayOfChars.length < 2) {
            return;
        }

        int i = 0;
        int j = arrayOfChars.length - 1;

        while (j > i) {
            char temp = arrayOfChars[i];
            arrayOfChars[i] = arrayOfChars[j];
            arrayOfChars[j] = temp;
            i++;
            j--;
        }

    }

}
