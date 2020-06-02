package com.eknv.algorithms.heap;


import org.springframework.util.Assert;

/**
 * Build minHeap of the given array.
 * Extract the minimum element/root and add it to the result
 * Keep removing elements and repeatedly build minHeap till we reach K.
 */
public class FindKSmallestElementsInArray {


    private FindKSmallestElementsInArray() {
    }

    public static int[] calculate(int[] arr, int k) {
        MinHeap minHeap = new MinHeap(arr);

        Assert.isTrue(k <= arr.length, "k <= arr.length");

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.extractMin();
        }
        return result;
    }

}

