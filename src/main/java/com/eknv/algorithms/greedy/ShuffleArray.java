package com.eknv.algorithms.greedy;

import com.eknv.util.Utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Write a method for doing an in-place shuffle of an array.
 * <p>
 * The shuffle must be "uniform," meaning each item in the original array
 * must have the same probability of ending up in each spot in the final array.
 * <p>
 * Assume that you have a method getRandom(floor, ceiling) for getting a random integer
 * that is >= floor and <= ceiling.
 */
public class ShuffleArray {

    private ShuffleArray() {
    }

    private static Random random = new SecureRandom();

    private static int getRandom(int floor, int ceiling) {
        return floor + random.nextInt((ceiling - floor) + 1);
    }

    /**
     * A Function to generate a random permutation of arr[]
     */
    public static int[] execute(int[] arr) {

        /**
         * Start from the last element and swap one by one.
         * We don't need to run for the first element that's why i > 0
         */
        for (int i = arr.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i (i included)
            int j = getRandom(0, i);

            // Swap arr[i] with the element at random index
            Utils.swap(arr, i, j);
        }

        return arr;
    }

} 

