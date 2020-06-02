package com.eknv.algorithms.divide_conquer;


/**
 * find the smallest positive missing number
 * in an unsorted array which may contain negative and duplicate values
 */
public class MissingNumberInUnsortedArray {

    private MissingNumberInUnsortedArray() {
    }

    public static int execute(int[] arr) {

        int length = arr.length;

        /**
         * keep track of the existance of each number in the following array
         */
        boolean[] present = new boolean[length + 1];

        for (int i = 0; i < length; i++) {

            /**
             * consider just the negative numbers
             */
            if (arr[i] > 0 && arr[i] <= length) {
                present[arr[i]] = true;
            }

        }

        /**
         * iterate from 1 upwards
         * and return the first number which isn't true in the present list
         */
        for (int i = 1; i <= length; i++) {
            if (!present[i]) {
                return i;
            }
        }


        /**
         * otherwise return the length incremented by one
         */
        return length + 1;
    }
}

