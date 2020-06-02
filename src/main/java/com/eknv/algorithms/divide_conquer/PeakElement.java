package com.eknv.algorithms.divide_conquer;

/**
 * Given an array of integers, find a peak element in it.
 * An array element is a peak if it is NOT smaller than its neighbours.
 * For corner elements, we need to consider only one neighbour.
 */
public class PeakElement {

    private PeakElement() {
    }


    /**
     * A wrapper over recursive function calculateRecursively()
     */
    public static int calculate(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == (arr.length - 1) || arr[mid] >= arr[mid + 1])) {
                return arr[mid];
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[mid];
    }


    /**
     * A wrapper over recursive function calculateRecursively()
     */
    public static int calculateRecursively(int[] arr) {
        return calculateRecursively(arr, 0, arr.length - 1);
    }


    /**
     * A binary search based function that returns index of a peak
     */
    private static int calculateRecursively(int[] arr, int start, int end) {

        /**
         * Find index of middle element
         */
        int mid = (start + end) / 2;


        /**
         * Compare middle element with its neighbours (if neighbours exist)
         */
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
            return arr[mid];
        }


        /**
         * If middle element is not peak and its left neighbor is
         * greater than it,then left half must have a peak element
         */
        else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return calculateRecursively(arr, start, mid - 1);
        }


        /**
         * If middle element is not peak and its right neighbor
         * is greater than it, then right half must have a peak
         * element
         */
        else {
            return calculateRecursively(arr, mid + 1, end);
        }
    }

} 
