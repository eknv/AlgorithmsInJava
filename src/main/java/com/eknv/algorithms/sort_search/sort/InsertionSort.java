package com.eknv.algorithms.sort_search.sort;


/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static int[] execute(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            /**
             * keep track of the value at i
             */
            int tempValue = arr[i];

            /**
             * for all the values before this index
             * if the values is bigger than this one
             * move those values to the right
             */
            int j = i - 1;
            while (j >= 0 && arr[j] > tempValue) {
                arr[j + 1] = arr[j];
                j--;
            }

            /**
             * at the end, put the tempValue to the last moved value, if any
             */
            arr[j + 1] = tempValue;
        }

        return arr;

    }


}