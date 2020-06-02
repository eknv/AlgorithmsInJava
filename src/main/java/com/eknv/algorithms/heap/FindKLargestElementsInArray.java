package com.eknv.algorithms.heap;


/**
 * Build maxHeap of the given array.
 * Extract the maximum element/root and add it to the result
 * Reduce the length of array and repeatedly build maxHeap till we reach K.
 */
public class FindKLargestElementsInArray {

    private FindKLargestElementsInArray() {
    }

    public static int[] calculate(int[] arr, int k) {
        int arraySize = arr.length;
        if (k <= arraySize) {
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                MaxHeap.buildMaxHeap(arr, arraySize);
                result[i] = arr[0];
                arr[0] = arr[--arraySize];
            }
            return result;
        }

        return arr;
    }

}