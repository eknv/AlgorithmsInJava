package com.eknv.algorithms.sort_search.sort;

import com.eknv.util.Utils;

/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static int[] execute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }


}