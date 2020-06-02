package com.eknv.algorithms.sort_search;

/**
 * Given an array A[] consisting 0s, 1s and 2s.
 * The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * <p>
 * This is another simpler implementation
 */
public class DutchNationalFlagSort2 {

    private DutchNationalFlagSort2() {
    }

    public static int[] execute(int[] arr) {

        /**
         * Count the number of 0s, 1s and 2s in the array
         */
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;

                default:
                    throw new IllegalArgumentException("wrong input");
            }
        }

        /**
         * Update the array
         * store all the 0s in the beginning
         * then all the 1s
         * finally all the 2s
         */
        int i = 0;

        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }

        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }

        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }

        return arr;
    }

}

