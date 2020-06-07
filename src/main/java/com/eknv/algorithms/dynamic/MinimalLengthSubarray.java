package com.eknv.algorithms.dynamic;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * <p>
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Here is the method signature:
 * <p>
 * class Solution:
 * def minSubArrayLen(self, nums, s):
 * # Fill this in
 * <p>
 * print Solution().minSubArrayLen([2, 3, 1, 2, 4, 3], 7)
 * <p>
 */
public class MinimalLengthSubarray {


    private MinimalLengthSubarray() {
    }


    public static int calculate(int[] arr, int sum) {

        int[] sums = new int[arr.length + 1];

        int[][] rangeMatrix = new int[arr.length + 1][arr.length + 1];


        for (int i = 1; i <= arr.length; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
        }

        rangeMatrix[0][0] = 0;

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {
                rangeMatrix[i][j] = sums[j] - sums[i];
                if (rangeMatrix[i][j] >= sum && j - i < minLength) {
                    minLength = j - i;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
