package com.eknv.algorithms.sort_search;


import org.springframework.util.Assert;

/**
 * A Simple Merge based O(n) solution to find median of two sorted arrays
 * In this implementation, both arrays should have the same size
 */
public class MedianTwoSortedArrays2 {

    private MedianTwoSortedArrays2() {
    }

    /**
     * function to calculate median
     */
    public static int calculate(int[] arr1, int[] arr2) {

        Assert.isTrue(arr1.length == arr2.length, "Both arrays should have the length");

        int length = arr1.length;

        int index1 = 0;
        int index2 = 0;

        /**
         * last and current value in the newly sorted array by merging the two sorted arrays
         */
        int prev = -1;
        int current = -1;

        boolean finished = false;

        /**
         * Since there are 2n elements, median will be average of elements
         * at index n and n+1 in the array obtained after merging ar1 and ar2
         */
        for (int count = 0; count <= length; count++) {

            /**
             * edge case
             * if we reach the end of one array, we can already stop
             * all elements of arr1 are smaller than smallest (or first) element of arr2
             */
            if (index1 == length) {
                prev = current;
                current = arr2[0];
                finished = true;
            }
            /**
             * all elements of arr2 are smaller than smallest(or first) element of arr1
             */
            else if (index2 == length) {
                prev = current;
                current = arr1[0];
                finished = true;
            }

            if (finished) {
                break;
            }

            /**
             * calculate the two median values
             * this algorithm is similar to merging two sorted arrays
             * since we stop at the middle of sorting, we will be in the middle of new array
             * and we will have the median values
             *
             * note that the new sorted array does not exist
             * we just keep track of the last two elements in that array
             */
            if (arr1[index1] < arr2[index2]) {
                prev = current;
                current = arr1[index1];
                index1++;
            } else {
                prev = current;
                current = arr2[index2];
                index2++;
            }
        }

        return (prev + current) / 2;
    }

}
