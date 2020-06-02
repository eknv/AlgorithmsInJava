package com.eknv.algorithms.dynamic;


public class Knapsack3 {

    private Knapsack3() {
    }

    /**
     * Returns the maximum value that can be put in a knapsack of capacity maxWeight
     */
    public static int calculate(int maxCapacity, int[] weights, int[] profits) {

        int length = profits.length;

        /**
         * edge cases
         */
        if (maxCapacity <= 0 || length == 0) {
            return 0;
        }

        int[] maxProfit = new int[maxCapacity + 1];


        /**
         * process all sub-arrays for all the capacities
         */
        for (int item = 0; item < length; item++) {
            for (int capacity = maxCapacity; capacity >= 0; capacity--) {

                /**
                 * include the item, if it is not more than the capacity
                 */
                if (weights[item] <= capacity) {
                    maxProfit[capacity] = Math.max(
                            profits[item] + maxProfit[capacity - weights[item]],
                            maxProfit[capacity]
                    );
                }

            }
        }

        return maxProfit[maxCapacity];
    }

}

