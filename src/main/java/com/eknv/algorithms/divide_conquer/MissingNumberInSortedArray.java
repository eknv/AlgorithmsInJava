package com.eknv.algorithms.divide_conquer;

/**
 * A binary search to find the only missing number
 * in a sorted array of distinct elements within limited range.
 */
public class MissingNumberInSortedArray {


    private MissingNumberInSortedArray() {
    }


    public static int calculate(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int mid = 0;

        while (endIndex > startIndex) {

            mid = (startIndex + endIndex) / 2;

            if ((arr[startIndex] - startIndex) != (arr[mid] - mid)) {
                endIndex = mid;
            } else if ((arr[endIndex] - endIndex) != (arr[mid] - mid)) {
                startIndex = mid + 1;
            }

        }

        return arr[mid] + 1;
    }

} 


