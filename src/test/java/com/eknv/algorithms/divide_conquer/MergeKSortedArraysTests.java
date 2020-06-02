package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MergeKSortedArraysTests {

    @Test
    public void test1() {

        int[][] arr1 = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]",
                Arrays.toString(MergeKSortedArrays.execute(arr1)));

        int[][] arr2 = {
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };

        assertEquals("[1, 2, 6, 9, 12, 20, 23, 34, 34, 90, 1000, 2000]",
                Arrays.toString(MergeKSortedArrays.execute(arr2)));

    }

    @Test
    public void test2() {

        int[][] arr1 = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]",
                Arrays.toString(MergeKSortedArrays2.execute(arr1)));

        int[][] arr2 = {
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };

        assertEquals("[1, 2, 6, 9, 12, 20, 23, 34, 34, 90, 1000, 2000]",
                Arrays.toString(MergeKSortedArrays2.execute(arr2)));

    }


}



