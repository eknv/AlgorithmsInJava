package com.eknv.algorithms.heap;

public class ConvertMaxHeap2MinHeap {


    private ConvertMaxHeap2MinHeap() {
    }

    public static int[] execute(int[] maxHeap) {

        /**
         * Consider maxHeap just an ordinary unsorted array
         * Build minHeap of the given array.
         * Return converted array in String format
         */
        MaxHeap.buildMaxHeap(maxHeap);

        return maxHeap;
    }

}
