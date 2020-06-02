package com.eknv.algorithms.dynamic;

/**
 * Given an array of integers, write a function to find
 * if any two subsets of the input array exist such that
 * the sum of both subsets is equal.
 * Notes:
 * - all of the elements in the array should be included in the two subsets
 * - no overlapping is allowed
 * - array will only consist of positive integers
 */
public class CanPartition {

    private CanPartition() {
    }

    public static boolean calculate(int[] numbers) {

        int length = numbers.length;

        /**
         * find the total sum
         */
        int total = 0;
        for (int i = 0; i < length; i++) {
            total += numbers[i];
        }

        /**
         * if 'sum' is a an odd number, we can't have two subsets with same total
         */
        if (total % 2 != 0) {
            return false;
        }

        /**
         * we are trying to find a subset of given numbers that has a total sum of ‘sum/2’
         */
        int sum = total / 2;


        /**
         * this matrix keeps track whether it is possible to build
         * a sum value in the range (0..sum) with values in the range (num[0]..num[n-1])
         */
        boolean[][] dpTable = new boolean[length][sum + 1];

        /**
         * if the sum is 0
         * we indeed can put it together using the existing numbers
         * by just taking nothing
         */
        for (int i = 0; i < length; i++) {
            dpTable[i][0] = true;
        }

        /**
         * with only one number,
         * we can form a subset only when
         * the required sum is equal to its value
         */
        for (int s = 1; s <= sum; s++) {
            dpTable[0][s] = numbers[0] == s;
        }

        /**
         * check whether we can put together the value sum (which is the half of the actual total)
         * by using some of the numbers in the array
         */
        for (int index = 1; index < length; index++) {
            for (int s = 1; s <= sum; s++) {
                /**
                 * if we could already put it together
                 * then we don't need the value at the index anymore, the answer is already true
                 */
                if (dpTable[index - 1][s]) {
                    dpTable[index][s] = true;
                }
                /**
                 * if the current number (at index i) is smaller than or equal to this sum,
                 * then we could build this sum with this number
                 * if we can build the value (sum - number) with all the previous numbers
                 */
                else if (s >= numbers[index]) {
                    dpTable[index][s] = dpTable[index - 1][s - numbers[index]];
                }
            }
        }

        /**
         * return the final result at the bottom right corner of the matrix
         */
        return dpTable[length - 1][sum];
    }


}

