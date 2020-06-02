package com.eknv.algorithms.sort_search.sort;

import com.eknv.util.Utils;

/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static int[] execute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Utils.swap(arr, i, minIndex);
        }
        return arr;
    }

}