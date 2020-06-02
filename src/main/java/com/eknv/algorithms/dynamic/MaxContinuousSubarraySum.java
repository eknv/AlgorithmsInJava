package com.eknv.algorithms.dynamic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class MaxContinuousSubarraySum {

    private static Logger logger = LoggerFactory.getLogger(MaxContinuousSubarraySum.class);

    private MaxContinuousSubarraySum() {
    }


    public static int calculate(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }

        logger.debug("Found Maximum Subarray between {} and {}", start, end);
        return maxSoFar;
    }

} 

