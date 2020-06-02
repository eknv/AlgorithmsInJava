package com.eknv.algorithms.greedy;

import com.eknv.algorithms.heap.MinHeap;


/**
 * Connect n ropes with minimum cost
 * The cost of connecting the ropes is the sum of the length of the the ropes themselves
 */
public class ConnectNPipesWithMinCost {

    private ConnectNPipesWithMinCost() {
    }

    public static int calculate(int[] pipeLengths) {

        /**
         * initial cost
         */
        int cost = 0;


        /**
         * put all the lengths in a minHeap to get sorted ascendingly
         */
        MinHeap minHeap = new MinHeap(pipeLengths);

        /**
         * continue till the size of the heap gets 1
         */
        while (!minHeap.isSizeOne()) {

            /**
             * extract the two shortest ropes from the minHeap
             */
            int min = minHeap.extractMin();
            int secondMin = minHeap.extractMin();

            /**
             * update the costs
             */
            cost += (min + secondMin);

            /**
             * put back the new rope back to the minHeap to get sorted again
             */
            minHeap.insertKey(min + secondMin);
        }

        /**
         * return the costs
         */
        return cost;
    }
}
