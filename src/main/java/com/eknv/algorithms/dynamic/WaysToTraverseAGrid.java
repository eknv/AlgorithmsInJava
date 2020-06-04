package com.eknv.algorithms.dynamic;

/**
 * Ways to Traverse a Grid
 * You get 2 integers n and m representing an n by m grid,
 * determine the number of ways you can get from the top-left to the bottom-right of the matrix y going only right or down.
 * <p>
 * Example:
 * n = 2, m = 2
 * <p>
 * This should return 2, since the only possible routes are:
 * Right, down
 * Down, right.
 */
public class WaysToTraverseAGrid {

    private WaysToTraverseAGrid() {
    }

    public static int calculate(int n, int m) {

        int[][] dpTable = new int[n][m];
        dpTable[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dpTable[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dpTable[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - 1];
            }
        }

        return dpTable[n - 1][m - 1];
    }
}
