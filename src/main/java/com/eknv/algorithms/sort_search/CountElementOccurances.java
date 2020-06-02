package com.eknv.algorithms.sort_search;


/**
 * Count occurrences of an element in an sorted array
 */
public class CountElementOccurances {

    private CountElementOccurances() {
    }

    /**
     * if x is present in arr[] then returns
     * the count of occurrences of x,
     * otherwise returns -1.
     **/
    public static int execute(int[] arr, int searchValue) {

        /**
         * get the index of the first occurrence
         */
        int startIndex = first(arr, 0, arr.length - 1, searchValue);

        /**
         * If x doesn't exist in arr[] then return -1
         */
        if (startIndex == -1) {
            return startIndex;
        }

        /**
         * Else get the index of last occurrence of x.
         * 		Note that we are only looking in the
         * 		subarray after first occurrence
         */
        int endIndex = last(arr, startIndex, arr.length - 1, searchValue);

        /**
         * return the difference between the end and start indexes
         */
        return endIndex - startIndex + 1;
    }


    /**
     * if x is present in arr[] then returns the
     * index of FIRST occurrence of x in arr[0..n-1],
     * otherwise returns -1
     */
    private static int first(int[] arr, int start, int end, int searchValue) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if ((mid == 0 || arr[mid - 1] < searchValue) && arr[mid] == searchValue) {
                return mid;
            } else if (searchValue > arr[mid]) {
                return first(arr, mid + 1, end, searchValue);
            } else {
                return first(arr, start, mid - 1, searchValue);
            }
        }
        return -1;
    }

    /**
     * if x is present in arr[] then returns the
     * index of LAST occurrence of x in arr[0..n-1],
     * otherwise returns -1
     */
    private static int last(int[] arr, int start, int end, int searchValue) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if ((mid == arr.length - 1 || searchValue < arr[mid + 1]) && arr[mid] == searchValue)
                return mid;
            else if (searchValue < arr[mid])
                return last(arr, start, mid - 1, searchValue);
            else
                return last(arr, mid + 1, end, searchValue);
        }
        return -1;
    }

} 
