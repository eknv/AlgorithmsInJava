package com.eknv.algorithms.divide_conquer;

public class MergeKSortedArrays2 {

    private MergeKSortedArrays2() {
    }

    public static int[] execute(int[]... arrays) {

        /**
         * calculate total length
         */
        int totalLength = 0;
        for (int[] a : arrays) {
            totalLength += a.length;
        }

        /**
         * create a new array to hold the merged values
         */
        int[] result = new int[totalLength];

        /**
         * create a new array to hold current index in each array
         */
        int[] idx = new int[arrays.length];

        /**
         * insert the entries one by one
         */
        for (int i = 0; i < totalLength; i++) {

            /**
             * iterate over all the arrays and update the min index and value
             */
            int minArrayIndex = -1;
            int minValue = 0;
            for (int j = 0; j < arrays.length; j++) {
                /**
                 * as long as we have not reached the end of this array
                 */
                if (idx[j] < arrays[j].length) {
                    int valueAtIndex = arrays[j][idx[j]];
                    if (minArrayIndex == -1 || valueAtIndex < minValue) {
                        minArrayIndex = j;
                        minValue = valueAtIndex;
                    }
                }
            }

            /**
             * Add to result array and step forward in appropriate source array
             */
            result[i] = minValue;
            idx[minArrayIndex]++;
        }

        return result;
    }

}


