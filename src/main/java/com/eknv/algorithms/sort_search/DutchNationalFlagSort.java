package com.eknv.algorithms.sort_search;

import com.eknv.util.Utils;

/**
 * Sort an array of 0, 1 and 2
 * Given an array A[] consisting 0s, 1s and 2s.
 * <p>
 * The functions should put all 0s first, then all 1s and all 2s in last.
 */
public class DutchNationalFlagSort {

    private DutchNationalFlagSort() {
    }

    /**
     * Sort the input array
     * the array is assumed to have values in {0, 1, 2}
     */
    public static int[] execute(int[] arr) {
        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;

        while (mid <= hi) {
            switch (arr[mid]) {
                case 0:
                    Utils.swap(arr, lo, mid);
                    lo++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    Utils.swap(arr, mid, hi);
                    hi--;
                    break;

                default:
                    throw new IllegalArgumentException("wrong input");

            }
        }

        return arr;
    }


}
