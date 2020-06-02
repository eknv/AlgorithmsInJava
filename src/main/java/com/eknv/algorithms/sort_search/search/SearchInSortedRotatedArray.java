package com.eknv.algorithms.sort_search.search;


import org.springframework.util.Assert;

/**
 * Given a sorted array of n integers that has been right rotated an unknown number of times,
 * write code to find an element in the array.
 * <p>
 * You may assume that the array was originally sorted in ascending order.
 * This array may also contain duplicate values.
 */
public class SearchInSortedRotatedArray {

    private SearchInSortedRotatedArray() {
    }

    public static int execute(int[] arr, int searchValue) {

        Assert.notNull(arr, "arr cannot be null");

        return search(arr, 0, arr.length - 1, searchValue);
    }


    /**
     * This implementation uses a modified version of binary search
     * The interesting property of a sorted + rotated array is that when you divide_conquer it into two halves,
     * at least one of the two halves will always be sorted.
     */
    private static int search(int[] arr, int left, int right, int searchValue) {
        int mid = (left + right) / 2;

        /**
         * Element found
         */
        if (searchValue == arr[mid]) {
            return mid;
        }

        if (right < left) {
            return -1;
        }

        /**
         * left side side is sorted
         */
        if (arr[left] < arr[mid]) {

            if (searchValue >= arr[left] && searchValue < arr[mid]) {
                return search(arr, left, mid - 1, searchValue);
            } else {
                return search(arr, mid + 1, right, searchValue);
            }
        }

        /**
         * right side is sorted
         */
        else if (arr[mid] < arr[right]) {

            if (searchValue > arr[mid] && searchValue <= arr[right]) {
                return search(arr, mid + 1, right, searchValue);
            } else {
                return search(arr, left, mid - 1, searchValue);
            }
        }

        /**
         * if all the values on the left side are the same
         */
        else if (arr[left] == arr[mid]) {

            if (arr[mid] != arr[right]) {

                return search(arr, mid + 1, right, searchValue);

            } else {

                int result = search(arr, left, mid - 1, searchValue);
                if (result != -1) {
                    return result;
                } else {
                    return search(arr, mid + 1, right, searchValue);
                }
            }
        }

        return -1;
    }

}
