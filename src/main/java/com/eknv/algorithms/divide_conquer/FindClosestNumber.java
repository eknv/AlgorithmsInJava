package com.eknv.algorithms.divide_conquer;

/**
 * Find closest number to a search value in an sorted array
 * Array may contain duplicate values and negative numbers.
 */
public class FindClosestNumber {

    private FindClosestNumber() {
    }


    /**
     * Returns element closest to target in arr[]
     */
    public static int execute(int[] arr, int searchValue) {

        int length = arr.length;

        /**
         * edge cases
         */
        if (searchValue <= arr[0]) {
            return arr[0];
        }

        if (searchValue >= arr[length - 1]) {
            return arr[length - 1];
        }


        /**
         * Doing binary search
         */
        int start = 0;
        int end = length;
        int mid = 0;

        while (start < end) {

            mid = (start + end) / 2;

            if (arr[mid] == searchValue) {
                return arr[mid];
            }

            /**
             * If target is less than array element, then search in left
             */
            else if (searchValue < arr[mid]) {

                /**
                 * if target is greater than previous to mid, return closest of two
                 */
                if (mid > 0 && searchValue > arr[mid - 1]) {
                    return getClosest(arr[mid - 1], arr[mid], searchValue);
                }

                /**
                 * Repeat for left half
                 */
                else {
                    end = mid;
                }

            }

            /**
             * target is greater than mid and mid+1 indexes
             */
            else if (mid < length - 1 && searchValue < arr[mid + 1]) {
                return getClosest(arr[mid], arr[mid + 1], searchValue);
            }

            /**
             * target is on the right side
             */
            else {
                start = mid + 1;
            }

        }

        /**
         * Only single element left after search
         */
        return arr[mid];
    }


    /**
     * Method to compare which one is the more close We find the closest by taking the difference
     * between the target and both values.
     * It assumes that val2 is greater than val1 and target lies between these two.
     */
    private static int getClosest(int val1, int val2, int target) {
        if (target - val1 >= val2 - target) {
            return val2;
        } else {
            return val1;
        }
    }

} 
