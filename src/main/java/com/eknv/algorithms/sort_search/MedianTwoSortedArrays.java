package com.eknv.algorithms.sort_search;


/**
 * Calculate the median as a double value
 * when the sum of the length of both arrays is an even number
 * <p>
 */
public class MedianTwoSortedArrays {

    private MedianTwoSortedArrays() {
    }

    /**
     * Function to find median of two sorted arrays
     */
    public static double calculate(int[] arr1, int[] arr2) {

        /**
         * handle the cases when one of the arrays is empty
         */
        if (arr1 == null) {
            return calculate(arr2, new int[]{});
        } else if (arr2 == null) {
            return calculate(arr1, new int[]{});
        }

        /**
         * we need to define the smaller array as the first parameter to
         * make sure that the time complexity will be O(log(min(n,m)))
         */
        if (arr1.length > arr2.length) {
            int[] first = arr2;
            int[] second = arr1;
            return calculate(first, second);
        }

        int len1 = arr1.length;
        int len2 = arr2.length;

        int minIndex = 0;
        int maxIndex = len1;
        int index1 = 0;
        int index2 = 0;
        int median = 0;

        while (minIndex <= maxIndex) {

            /**
             * index1 to partition the first array
             */
            index1 = (minIndex + maxIndex) / 2;

            /**
             * index2 to partition the second array
             */
            index2 = ((len1 + len2 + 1) / 2) - index1;

            /**
             * if i = n, it means that Elements
             * from a[] in the second half is an
             * empty set. and if j = 0, it means
             * that Elements from b[] in the first
             * half is an empty set. so it is
             * necessary to check that, because we
             * compare elements from these two
             * groups. Searching on right
             */

            /**
             * we have not reached the end of the arrays
             */
            if (index1 < len1 && index2 > 0 && arr2[index2 - 1] > arr1[index1]) {
                minIndex = index1 + 1;
            }

            /**
             * if i = 0, it means that Elements
             * from a[] in the first half is an
             * empty set and if j = m, it means
             * that Elements from b[] in the second
             * half is an empty set. so it is
             * necessary to check that, because
             * we compare elements from these two
             * groups. searching on left
             */
            else if (index1 > 0 && index2 < len2 && arr1[index1 - 1] > arr2[index2]) {
                maxIndex = index1 - 1;
            }

            /**
             * we have found the desired halves.
             */
            else {

                /**
                 * this condition happens when we
                 * don't have any elements in the
                 * first half from a[] so we
                 * return the last element in
                 * b[] from the first half.
                 */
                if (index1 == 0) {
                    median = arr2[index2 - 1];
                }

                /**
                 * and this condition happens when
                 * we don't have any elements in the
                 * first half from b[] so we
                 * return the last element in
                 * a[] from the first half.
                 */
                else if (index2 == 0) {
                    median = arr1[index1 - 1];
                } else {
                    median = Math.max(arr1[index1 - 1], arr2[index2 - 1]);
                }

                break;
            }
        }

        /**
         * Calculating the median.
         * If number of elements is odd
         * there is one middle element.
         */
        if ((len1 + len2) % 2 == 1) {
            return (double) median;
        }


        /**
         * Elements from a[] in the
         * second half is an empty set.
         */
        if (index1 == len1) {
            return (median + arr2[index2]) / 2.0;
        }


        /**
         * Elements from b[] in the
         * second half is an empty set.
         */
        if (index2 == len2) {
            return (median + arr1[index1]) / 2.0;
        }

        return (median + Math.min(arr1[index1], arr2[index2])) / 2.0;
    }
}

