package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * Given an array of integers, find the highest product you can get from three of the integers.
 * The input arrayOfInts will always have at least three integers.
 */
public class HighestProductOf3 {

    private HighestProductOf3() {
    }

    public static int calculate(int[] arr) {

        Assert.notNull(arr, "intArray");
        Assert.isTrue(arr.length >= 3, "intArray.length >= 3");

        int n = arr.length;

        /**
         * Sort the array in ascending order
         */
        Arrays.sort(arr);

        /**
         *
         * Note, we are just interested in the following numbers:
         * - the 3 biggest
         * - the 2 smallest
         *
         * it is also possible to iterate through the array just once and figure out these numbers
         * that would have a time-complexity of O(n) which is better than O(nlog(n)) as for sorting
         */

        /**
         * return the maximum between
         * - product of last three elements
         * - product of first two elements and last element
         *
         * main possibilities:
         * - in case all numbers are positive or negative, then the first case will be the max
         * - in case just two numbers are positive, then the second case will be the biggest
         * - in case just one number is positive, then also the second case
         */
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);

    }

}
