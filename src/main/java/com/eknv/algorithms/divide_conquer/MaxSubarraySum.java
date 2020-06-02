package com.eknv.algorithms.divide_conquer;


/**
 * In an unsorted array, the maximum sum of a continuous subarray is the one
 * who’s elements — when added together — give the largest possible sum.
 * <p>
 * This problem is a tricky one because the array might have negative integers in any position,
 * so we have to cater to those negative integers while choosing the continuous subarray with the largest positive values.
 * <p>
 * Inputs
 * int arr[] (array of integers)
 * int arrSize (size of the array)
 * <p>
 * Output
 * int (maximum subarray sum)
 */
public class MaxSubarraySum {


    private MaxSubarraySum() {
    }


    public static int calculate(int[] arr) {
        return calculate(arr, 0, arr.length - 1);
    }


    /**
     * Returns sum of maxium sum subarray in arr[l..h]
     */
    private static int calculate(int[] arr, int start, int end) {

        if (start == end) {
            return arr[start];
        }

        int middle = (start + end) / 2;

        /**
         * Return maximum of following three possible cases:
         * a) Maximum subarray sum in left half
         * b) Maximum subarray sum in right half
         * c) Maximum subarray sum such that the subarray crosses the midpoint
         */
        return Math.max(Math.max(
                calculate(arr, start, middle),
                calculate(arr, middle + 1, end)),
                maxCrossingSum(arr, start, middle, end)
        );
    }

    /**
     * Find the maximum possible sum in arr[]
     * such that arr[m] is part of it
     */
    private static int maxCrossingSum(int[] arr, int start, int middle, int end) {
        /**
         * Include elements on left of mid.
         */
        int sum = 0;
        int highestLeftSum = Integer.MIN_VALUE;
        for (int i = middle; i >= start; i--) {
            sum = sum + arr[i];
            if (sum > highestLeftSum) {
                highestLeftSum = sum;
            }
        }

        /**
         * Include elements on right of mid
         */
        sum = 0;
        int highestRightSum = Integer.MIN_VALUE;
        for (int i = middle + 1; i <= end; i++) {
            sum = sum + arr[i];
            if (sum > highestRightSum) {
                highestRightSum = sum;
            }
        }

        /**
         * Return sum of elements on left and right of mid
         * returning only left_sum + right_sum will fail for [-2, 1]
         */
        return Math.max(highestLeftSum + highestRightSum, Math.max(highestLeftSum, highestRightSum));
    }

} 

