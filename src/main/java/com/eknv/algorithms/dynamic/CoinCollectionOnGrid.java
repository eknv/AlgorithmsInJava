package com.eknv.algorithms.dynamic;

import org.springframework.util.Assert;

/**
 * Given a rectangular grid where each cell contains some coins.
 * You are at the first row and you want to go to the last row
 * with the objective of collecting the maximum number of coins on the way.
 * <p>
 * The allowed moves are down, left diagonal down and right diagonal down.
 * And you are not allowed to step out of rectangle.
 * So what is maximum number or coins that you can accumulate?
 * NOTE- You can start from any point on first row and end on any point on last row.
 * Each entry in grid is positive i.e. greater than 0.
 * <p>
 */
public class CoinCollectionOnGrid {


    private CoinCollectionOnGrid() {
    }

    public static int calculate(int[][] grid) {

        Assert.notNull(grid, "grid");
        Assert.isTrue(grid.length > 0, "grid.length > 0");

        /**
         * this array keeps track of the max sum values for each position in the grid
         */
        int[][] maxSums = new int[grid.length][grid[0].length];

        /**
         * the final max sum that can be achieved in the grid
         */
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // first row
                if (i == 0) {
                    maxSums[i][j] = grid[i][j];
                } else {
                    maxSums[i][j] = max(grid, maxSums, i, j);
                }
                if (i == grid.length - 1 && maxSums[i][j] > maxSum) {
                    maxSum = maxSums[i][j];
                }
            }
        }

        return maxSum;
    }

    /**
     * helper method
     *
     * @param grid    the grid
     * @param maxSums maxSums array
     * @param i       row index 0 based
     * @param j       column index 0 based
     * @return the max value for the given position in the grid
     */
    private static int max(int[][] grid, int[][] maxSums, int i, int j) {
        if (j > 0 && j < grid[0].length - 1) {
            return Math.max(
                    Math.max(grid[i][j] + maxSums[i - 1][j - 1], grid[i][j] + maxSums[i - 1][j]), grid[i][j] + maxSums[i - 1][j + 1]);
        } else if (j == 0) {
            return Math.max(grid[i][j] + maxSums[i - 1][j], grid[i][j] + maxSums[i - 1][j + 1]);
        } else {
            return Math.max(grid[i][j] + maxSums[i - 1][j], grid[i][j] + maxSums[i - 1][j - 1]);
        }
    }

}
