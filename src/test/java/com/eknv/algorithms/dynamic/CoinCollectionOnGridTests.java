package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoinCollectionOnGridTests {

    @Test
    void test1() {
        int[][] grid = new int[][]{
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1},
        };

        assertEquals(105, CoinCollectionOnGrid.calculate(grid));
    }

    @Test
    void test2() {
        int[][] grid = new int[][]{
                {1, 21, 10, 4},
                {100, 3, 23, 1},
                {1, 1, 20, 101},
                {1, 2, 2, 1},
        };

        assertEquals(147, CoinCollectionOnGrid.calculate(grid));
    }

    @Test
    void testAllTheSame() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        assertEquals(4, CoinCollectionOnGrid.calculate(grid));
    }

    @Test
    void testOneRow() {
        int[][] grid = new int[][]{
                {1, 21, 10, 4}
        };

        assertEquals(21, CoinCollectionOnGrid.calculate(grid));
    }

    @Test
    void testNotEmptyGrid() {
        int[][] grid = new int[][]{};
        assertThrows(Exception.class, () -> CoinCollectionOnGrid.calculate(grid));
    }

    @Test
    void testNotNull() {
        int[][] grid = null;
        assertThrows(Exception.class, () -> CoinCollectionOnGrid.calculate(grid));
    }

}
