package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FreeSquaresInMatrixTests {

    @Test
    void test1() {
        int[][] board = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };

        assertEquals(4, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test2() {
        int[][] board = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
        };

        assertEquals(2, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test3() {
        int[][] board = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
        };

        assertEquals(2, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test4() {
        int[][] board = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        };

        assertEquals(2, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test5() {
        int[][] board = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        };

        assertEquals(1, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test6() {
        int[][] board = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        assertEquals(0, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test7() {
        int[][] board = new int[][]{{1}};

        assertEquals(1, FreeSquaresInMatrix.calculate(board));
    }

    @Test
    void test8() {
        int[][] board = new int[][]{{0}};

        assertEquals(0, FreeSquaresInMatrix.calculate(board));
    }


    @Test
    void testNotEmptyBoard() {
        int[][] board = new int[][]{};
        assertThrows(Exception.class, () -> CoinCollectionOnGrid.calculate(board));
    }

    @Test
    void testNotNull() {
        int[][] board = null;
        assertThrows(Exception.class, () -> CoinCollectionOnGrid.calculate(board));
    }


}
