package com.eknv.algorithms.sort_search.search;

/**
 * Binary search in an already sorted array
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int execute(int[] sortedArray, int value) {
        if (sortedArray == null || sortedArray.length == 0) {
            return -1;
        }
        return execute(sortedArray, 0, sortedArray.length - 1, value);
    }


    private static int execute(int[] sortedArray, int start, int end, int value) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (sortedArray[mid] == value) {
            return mid;
        } else if (sortedArray[mid] < value) {
            return execute(sortedArray, mid + 1, end, value);
        } else {
            return execute(sortedArray, 0, mid - 1, value);
        }

    }

}
