package com.eknv.algorithms.dynamic;

import org.springframework.util.Assert;

/**
 * You are given a matrix of MxN boolean values representing a board of free (True) or occupied (False) fields.
 * Find the size of the largest square of free fields.
 * <p>
 */
public class FreeSquaresInMatrix {


    private FreeSquaresInMatrix() {
    }

    public static int calculate(int[][] board) {

        Assert.notNull(board, "board");
        Assert.isTrue(board.length > 0, "board.length>0");

        int largestSquareSize = 0;
        int[][] dpTable = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0) {
                    dpTable[i][j] = board[i][j];
                } else if (isSquareFree(board, i, j)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                } else {
                    dpTable[i][j] = board[i][j];
                }
                if (dpTable[i][j] > largestSquareSize) {
                    largestSquareSize = dpTable[i][j];
                }
            }
        }

        return largestSquareSize;
    }

    private static boolean isSquareFree(int[][] board, int i, int j) {
        return board[i][j] == 1
                && board[i][j - 1] == 1
                && board[i - 1][j] == 1
                && board[i - 1][j - 1] == 1;
    }
}

