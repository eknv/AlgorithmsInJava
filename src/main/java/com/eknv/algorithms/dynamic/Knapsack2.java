package com.eknv.algorithms.dynamic;/* A Naive recursive implementation of 0-1 Knapsack problem */


/**
 * Calculate the maximum value that can be put in a knapsack of capacity W
 * Recursive approach
 */
public class Knapsack2 {

    private Knapsack2() {
    }

    public static int calculate(int capacity, int[] weights, int[] values) {
        if (values.length == 0 || capacity == 0) {
            return 0;
        }

        return calculate(capacity, weights, values, values.length - 1);
    }


    private static int calculate(int capacity, int[] weights, int[] values, int index) {

        /**
         * base case
         */
        if (index == -1 || capacity == 0) {
            return 0;
        }

        /**
         * if weight of the current item is bigger than the capacity
         * it cannot be taken, move on to the next item
         */
        if (weights[index] > capacity) {
            return calculate(capacity, weights, values, index - 1);
        }

        /**
         * otherwise, the value between these two cases:
         * - taking this item
         * - not taking this item
         */
        else return Math.max(
                values[index] + calculate(capacity - weights[index], weights, values, index - 1),
                calculate(capacity, weights, values, index - 1)
        );
    }

}

