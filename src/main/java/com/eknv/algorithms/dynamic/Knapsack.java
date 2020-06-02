package com.eknv.algorithms.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Imagine that you’re a burglar at a jewelry store with a knapsack.
 * Your goal is to choose a combination of jewelry that results in the most profit.
 * Each item can only be selected once, which means we either skip it or put it in the knapsack.
 */
public class Knapsack {

    private static Logger logger = LoggerFactory.getLogger(Knapsack.class);

    private Knapsack() {
    }

    /**
     * Returns the maximum value that can be put in a knapsack of capacity maxWeight
     */
    public static int calculate(int maxWeight, int[] itemWeight, int[] itemValue) {

        int numberOfItems = itemValue.length;

        /**
         * first index keeps track of the first i items
         * second index keeps track of the weight
         */
        int[][] profit = new int[numberOfItems + 1][maxWeight + 1];

        for (int i = 0; i <= numberOfItems; i++) {
            for (int weight = 0; weight <= maxWeight; weight++) {
                /**
                 * if no item or weight is 0
                 */
                if (i == 0 || weight == 0) {
                    profit[i][weight] = 0;
                }
                /**
                 * if the item weight is less than the available weight
                 */
                else if (itemWeight[i - 1] <= weight) {
                    profit[i][weight] = Math.max(
                            itemValue[i - 1] + profit[i - 1][weight - itemWeight[i - 1]], // taking the item i
                            profit[i - 1][weight]                                         // not taking the item i
                    );

                }
                /**
                 * otherwise we cannot take this item
                 */
                else {
                    profit[i][weight] = profit[i - 1][weight];
                }

            }
        }


        if (logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 0; i <= numberOfItems; i++) {
                for (int weight = 0; weight <= maxWeight; weight++) {
                    sb.append(profit[i][weight]).append(" ");
                }
                sb.append("\n");
            }
            logger.debug(sb.toString());
        }

        return profit[numberOfItems][maxWeight];
    }

}

