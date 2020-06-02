package com.eknv.algorithms.heap;

import com.eknv.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinHeap {

    private Logger logger = LoggerFactory.getLogger(MinHeap.class);

    private int[] heapArray;
    private int heapSize;
    private int capacity;

    public MinHeap(int... arr) {
        this.heapArray = arr;
        this.heapSize = arr.length;
        this.capacity = arr.length;
        buildMinHeap();
    }


    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * index of left child of node at index i
     */
    public int left(int i) {
        return 2 * i + 1;
    }


    /**
     * index of right child of node at index i
     */
    public int right(int i) {
        return 2 * i + 2;
    }


    /**
     * extract and remove the minimum element (or root) from min heap
     */
    public int extractMin() {
        if (heapSize <= 0) {
            return Integer.MAX_VALUE;
        }

        if (heapSize == 1) {
            heapSize--;
            return heapArray[0];
        }

        // Store the minimum value, and remove it from heap
        int root = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        heapSize--;
        minHeapify(0);

        return root;
    }


    /**
     * insert new key
     */
    public void insertKey(int k) {
        if (heapSize >= capacity) {
            logger.debug("Overflow: Could not insertKey");
            return;
        }

        /**
         * first insert the new key at the end
         */
        heapSize++;
        int i = heapSize - 1;
        heapArray[i] = k;

        /**
         * fix the min heap property if it is violated
         */
        while (heapArray[parent(i)] > heapArray[i] && i != 0) {
            Utils.swap(heapArray, i, parent(i));
            i = parent(i);
        }
    }


    public boolean isSizeOne() {
        return heapSize == 1;
    }

    public int[] asArray() {
        return heapArray;
    }


    private void minHeapify(int index) {
        int smallest = index;

        /**
         * check parent nodes only
         */
        while (smallest < heapSize / 2) {

            int left = left(index);
            int right = right(index);

            if (left < heapSize && heapArray[left] < heapArray[index]) {
                smallest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            /**
             * swap parent with smallest child
             */
            if (smallest != index) {
                Utils.swap(heapArray, index, smallest);
                index = smallest;
            } else {
                /**
                 * if heap property is satisfied
                 */
                break;
            }

        }
    }


    private void buildMinHeap() {

        /**
         * swap smallest children with the parent nodes
         */
        for (int i = (heapArray.length - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

}