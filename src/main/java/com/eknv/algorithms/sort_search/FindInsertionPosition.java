package com.eknv.algorithms.sort_search;

public class FindInsertionPosition {

    private FindInsertionPosition() {
    }

    public static int execute(int[] arr, int value) {

        if (arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int pos = -1;
        int midIndex;

        while (start <= end) {
            midIndex = (start + end) / 2;
            if (value == arr[midIndex]) {
                return midIndex;
            } else if (value < arr[midIndex]) {
                pos = midIndex;
                end = midIndex - 1;
            } else if (value > arr[midIndex]) {
                pos = midIndex + 1;
                start = midIndex + 1;
            }
        }

        return pos;
    }

}