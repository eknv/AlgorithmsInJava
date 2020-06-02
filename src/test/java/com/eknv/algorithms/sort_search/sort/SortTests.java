package com.eknv.algorithms.sort_search.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTests {

    @Test
    void test1() {
        String expectedResult = "[-100, 0, 0, 1, 4, 4, 5, 5, 95, 200]";

        assertEquals(expectedResult, Arrays.toString(BubbleSort.execute(new int[]{5, 4, 1, 0, 5, 95, 4, -100, 200, 0})));
        assertEquals(expectedResult, Arrays.toString(InsertionSort.execute(new int[]{5, 4, 1, 0, 5, 95, 4, -100, 200, 0})));
        assertEquals(expectedResult, Arrays.toString(MergeSort.execute(new int[]{5, 4, 1, 0, 5, 95, 4, -100, 200, 0})));
        assertEquals(expectedResult, Arrays.toString(QuickSort.execute(new int[]{5, 4, 1, 0, 5, 95, 4, -100, 200, 0})));
        assertEquals(expectedResult, Arrays.toString(SelectionSort.execute(new int[]{5, 4, 1, 0, 5, 95, 4, -100, 200, 0})));
    }

    /**
     * empty list
     */
    @Test
    void test2() {
        String expectedResult = "[]";

        assertEquals(expectedResult, Arrays.toString(BubbleSort.execute(new int[]{})));
        assertEquals(expectedResult, Arrays.toString(InsertionSort.execute(new int[]{})));
        assertEquals(expectedResult, Arrays.toString(MergeSort.execute(new int[]{})));
        assertEquals(expectedResult, Arrays.toString(QuickSort.execute(new int[]{})));
        assertEquals(expectedResult, Arrays.toString(SelectionSort.execute(new int[]{})));
    }

    /**
     * same values
     */
    @Test
    void test3() {
        String expectedResult = "[1, 1, 1]";

        assertEquals(expectedResult, Arrays.toString(BubbleSort.execute(new int[]{1, 1, 1})));
        assertEquals(expectedResult, Arrays.toString(InsertionSort.execute(new int[]{1, 1, 1})));
        assertEquals(expectedResult, Arrays.toString(MergeSort.execute(new int[]{1, 1, 1})));
        assertEquals(expectedResult, Arrays.toString(QuickSort.execute(new int[]{1, 1, 1})));
        assertEquals(expectedResult, Arrays.toString(SelectionSort.execute(new int[]{1, 1, 1})));
    }

}
