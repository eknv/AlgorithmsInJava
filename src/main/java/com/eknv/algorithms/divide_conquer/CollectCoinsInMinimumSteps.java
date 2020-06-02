package com.eknv.algorithms.divide_conquer;

/**
 * Collect all coins in minimum number of steps
 * <p>
 * Given many stacks of coins which are arranged adjacently. We need to collect all these coins in the minimum number of steps
 * where in one step we can collect one horizontal line of coins or vertical line of coins and collected coins should be continuous.
 * <p>
 */
public class CollectCoinsInMinimumSteps {

    private CollectCoinsInMinimumSteps() {
    }

    /**
     * method returns minimum number of step to
     * collect coin from stack, with height in
     * heights array
     */
    public static int calculate(int[] heights) {
        return calculateRecursively(heights, 0, heights.length, 0);
    }

    /**
     * recursive method to collect coins from height array l to r
     * with height h already collected
     */
    private static int calculateRecursively(int[] heights, int left, int right, int h) {

        /**
         * cover the edge cases
         */
        if (left >= right) {
            return 0;
        }

        /**
         * get minimum height index
         */
        int minHeightIndex = left;
        for (int i = left; i < right; i++) {
            if (heights[i] < heights[minHeightIndex]) {
                minHeightIndex = i;
            }
        }

        /**
         * choose minimum from
         * 	1) collecting coins using all vertical lines (total r - l)
         * 	2) collecting coins using lower horizontal lines and recursively on left and right segments
         */
        return Math.min(right - left,
                calculateRecursively(heights, left, minHeightIndex, heights[minHeightIndex]) +
                        calculateRecursively(heights, minHeightIndex + 1, right, heights[minHeightIndex]) +
                        heights[minHeightIndex] - h);
    }

}

