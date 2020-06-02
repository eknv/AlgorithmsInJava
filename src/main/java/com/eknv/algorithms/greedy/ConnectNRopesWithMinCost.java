package com.eknv.algorithms.greedy;


/**
 * Connect N ropes with minimum cost
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectNRopesWithMinCost {

    private ConnectNRopesWithMinCost() {
    }

    public static int calculate(Integer[] ropeLengths) {

        /**
         * use a priority queue to keep the entries sorted ascendingly
         */
        Queue<Integer> sortedList = new PriorityQueue<>();

        /**
         * add the items to the sorted list
         */
        Collections.addAll(sortedList, ropeLengths);

        int costs = 0;

        /**
         * continue as long as the list is not empty
         */
        while (sortedList.size() > 1) {

            /**
             * Extract shortest two ropes from the list
             */
            //
            int first = sortedList.poll();
            int second = sortedList.poll();

            /**
             * increment the costs by the sum of the two ropes
             */
            costs += first + second;

            /**
             * add the new rope to the list to keep it sorted
             */
            sortedList.add(first + second);
        }

        return costs;
    }

}

