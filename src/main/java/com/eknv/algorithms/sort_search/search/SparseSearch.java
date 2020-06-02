package com.eknv.algorithms.sort_search.search;

/**
 * Binary search in sparse array
 * <p>
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 */
public class SparseSearch {

    private static final String EMPTY_STRING = "";

    private SparseSearch() {
    }

    /**
     * Binary Search in an array with blanks
     *
     * @return match index in the array or -1 if no match could be found
     */
    public static int sparseSearch(String[] arr, String searchValue) {
        return binarySearch(arr, 0, arr.length, searchValue);
    }


    private static int binarySearch(String[] arr, int startIndex, int endIndex, String searchValue) {

        if (startIndex > endIndex) {
            return -1;
        }

        int mid = (startIndex + endIndex) / 2;

        /**
         * Main part, additional to binary search
         * if the middle is empty, we go both ways 
         * and try to find the first entry which is not empty
         */
        if (EMPTY_STRING.equals(arr[mid])) {
            int left = mid - 1;
            int right = mid + 1;

            boolean finished = false;

            while (true) {

                /**
                 * everything empty in the given range
                 */
                if (left < startIndex && right > endIndex) {
                    return -1;
                } else if (left >= startIndex && !EMPTY_STRING.equals(arr[left])) {
                    mid = left;
                    finished = true;
                } else if (right <= endIndex && !EMPTY_STRING.equals(arr[right])) {
                    mid = right;
                    finished = true;
                }

                if (finished) {
                    break;
                } else {
                    left--;
                    right++;
                }

            }
        }

        /**
         * Normal Binary Search
         */
        if (searchValue.equals(arr[mid])) {
            return mid;
        } else if (searchValue.compareTo(arr[mid]) < 0) {
            return binarySearch(arr, startIndex, mid - 1, searchValue);
        } else {
            return binarySearch(arr, mid + 1, endIndex, searchValue);
        }
    }

}

