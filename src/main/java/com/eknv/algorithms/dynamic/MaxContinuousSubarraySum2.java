package com.eknv.algorithms.dynamic;


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
public class MaxContinuousSubarraySum2 {


    private MaxContinuousSubarraySum2() {
    }


    public static int calculate(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

} 

