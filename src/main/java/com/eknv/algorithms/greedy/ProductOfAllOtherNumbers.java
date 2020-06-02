package com.eknv.algorithms.greedy;

import java.util.Arrays;

/**
 * You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
 * <p>
 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
 * <p>
 * For example, given:
 * <p>
 * [1, 7, 3, 4]
 * <p>
 * your method would return:
 * <p>
 * [84, 12, 28, 21]
 * <p>
 * by calculating:
 * <p>
 * [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
 * <p>
 * Here's the catch: You can't use division in your solution!
 */
public class ProductOfAllOtherNumbers {

    private ProductOfAllOtherNumbers() {
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] nums) {

        final int N = nums.length;
        int[] prods = new int[N];
        Arrays.fill(prods, 1);
        for (int i = 0, pi = 1, j = N - 1, pj = 1;
             (i < N) && (j >= 0);
             pi *= nums[i++], pj *= nums[j--]) {
            prods[i] *= pi;
            prods[j] *= pj;
        }
        return prods;
    }

}
