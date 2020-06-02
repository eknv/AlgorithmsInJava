package com.eknv.algorithms.sort_search.sort;

import com.eknv.util.Utils;

import java.security.SecureRandom;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Time complexity: O(nlog(n)) to O(n​^2​​)
 * Space complexity: O(n)
 */
public class QuickSort {

    private static Random random = new SecureRandom();

    private QuickSort() {
    }

    public static int[] execute(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }


    public static void sort(int[] arr, int left, int right) {
        if (left < right) {

            int pivotIndex = partition(arr, left, right);
            /**
             * recursively sort the elements on both sides of the pivot
             */
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }


    private static int partition(int[] arr, int left, int right) {

        /**
         * choose a pivot
         */
        int pivotIndex = choosePivotIndex(left, right);
        int pivotValue = arr[pivotIndex];

        /**
         * put the pivot to the end
         */
        Utils.swap(arr, pivotIndex, right);

        /**
         * start from the left side
         */
        int index = left;

        /**
         * compare all the elements with the pivot
         * if they are smaller, move them to the left side
         */
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivotValue) {
                Utils.swap(arr, index++, i);
            }
        }

        /**
         * then move the pivot to the end of the left section
         */
        Utils.swap(arr, index, right);

        /**
         * at this point, everything on the left side of this index
         * is smaller than pivot and everything on the right side of it
         * is bigger
         */
        return index;
    }


    /**
     * choose the median between 3 random numbers in the given range
     * a good pivot improves the performance of the quick search
     */
    private static int choosePivotIndex(int left, int right) {
        /**
         * take 3 random numbers
         */
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(left + random.nextInt(right - left + 1));
        queue.add(left + random.nextInt(right - left + 1));
        queue.add(left + random.nextInt(right - left + 1));
        /**
         * remove the top and return the one in the middle
         */
        queue.remove();
        return queue.remove();
    }


}

