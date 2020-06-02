package com.eknv.algorithms.sort_search.sort;

/**
 * Time complexity: O(nlog(n))
 * - O(log(n))  = number of divisions = height of the tree
 * - O(n)       = merging the sorted sub-arrays
 * Space complexity: O(n)
 */
public class MergeSort {

    private MergeSort() {
    }

    public static int[] execute(int[] arr) {
        execute(arr, 0, arr.length - 1);
        return arr;
    }


    private static void execute(int[] arr, int left, int right) {

        if (left < 0 || right > arr.length - 1) {
            return;
        }

        if (right > left) {
            int mid = (right + left) / 2;
            execute(arr, left, mid);
            execute(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * merge the sorted sub arrays
     */
    private static void merge(int[] arr, int start, int mid, int end) {

        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        /**
         * define two arrays and initialize them with the already sorted values
         *
         * we need these copies so that we can overwrite
         * the actual array on the respective positions
         */
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = arr[start + i];
        }
        for (int i = 0; i < rightSize; ++i) {
            rightArray[i] = arr[mid + 1 + i];
        }

        /**
         * do the merging
         */
        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                arr[index] = leftArray[leftIndex];
                index++;
                leftIndex++;
            } else {
                arr[index] = rightArray[rightIndex];
                index++;
                rightIndex++;
            }
        }

        /**
         * one of the following two blocks will actually be called
         */
        while (leftIndex < leftSize) {
            arr[index] = leftArray[leftIndex];
            index++;
            leftIndex++;
        }

        while (rightIndex < rightSize) {
            arr[index] = rightArray[rightIndex];
            index++;
            rightIndex++;
        }

    }

}