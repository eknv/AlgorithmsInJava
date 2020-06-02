package com.eknv.algorithms.heap;

import com.eknv.util.Utils;


public class MaxHeap {

    private MaxHeap() {
    }

    private static void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;
        while (largest < heapSize / 2) {      // check parent nodes only
            int left = (2 * index) + 1;       //left child
            int right = (2 * index) + 2;      //right child

            if (left < heapSize && heapArray[left] > heapArray[index]) {
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != index) { // swap parent with largest child
                Utils.swap(heapArray, index, largest);
                index = largest;
            } else {
                break; // if heap property is satisfied
            }
        }
    }

    public static int[] buildMaxHeap(int[] heapArray, int heapSize) {
        /**
         * swap largest child to parent node
         */
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
        return heapArray;
    }

    public static int[] buildMaxHeap(int[] heapArray) {
        int heapSize = heapArray.length;
        /**
         * swap largest child to parent node
         */
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
        return heapArray;
    }

}