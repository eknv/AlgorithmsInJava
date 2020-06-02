package com.eknv.algorithms.greedy;


/**
 * Calculate the biggest number created from the digits of a given number
 */
public class MaxNumberFromDigits {

    private MaxNumberFromDigits() {
    }

    public static int calculate(int num) {

        /**
         * array to store count of digits (0..9)
         */
        int[] count = new int[10];

        /**
         * convert the given number to string to extract the digits
         */
        String str = Integer.toString(num);

        /**
         * update the count array
         */
        for (int i = 0; i < str.length(); i++) {
            /**
             * note the folowing syntax - '0'
             * it gives the relative index to the number 0
             */
            count[str.charAt(i) - '0']++;
        }

        int result = 0;
        int multiplier = 1;

        /**
         * Traversing the count array to calculate the maximum number
         */
        for (int i = 1; i <= 9; i++) {
            while (count[i] > 0) {
                result = result + (multiplier * i);
                multiplier *= 10;
                count[i]--;
            }
        }

        /**
         * for any number of 0s
         */
        result *= Math.pow(10, count[0]);

        return result;
    }

}
