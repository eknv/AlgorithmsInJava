package com.eknv.algorithms.greedy;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of size n that has the following specifications:
 * <p>
 * - Each element in the array contains either a policeman or a thief.
 * - Each policeman can catch only one thief.
 * - A policeman cannot catch a thief who is more than K units away from the policeman.
 * <p>
 * We need to find the maximum number of thieves that can be caught.
 */
public class PoliceCatchThief {


    private PoliceCatchThief() {
    }

    /**
     * Returns maximum number of thieves that can be caught.
     */
    public static int calculate(char[] arr, int maxDistance) {

        int maxNumberOfCatches = 0;

        List<Integer> thiefIndices = new ArrayList<>();
        List<Integer> policeIndices = new ArrayList<>();

        /**
         * keep track of the indices in the lists
         */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                policeIndices.add(i);
            } else if (arr[i] == 'T') {
                thiefIndices.add(i);
            }
        }

        int thiefIndex = 0;
        int policeIndex = 0;
        while (thiefIndex < thiefIndices.size() && policeIndex < policeIndices.size()) {
            // can be caught
            if (Math.abs(thiefIndices.get(thiefIndex) - policeIndices.get(policeIndex)) <= maxDistance) {
                maxNumberOfCatches++;
                thiefIndex++;
                policeIndex++;
            }
            // increment the minimum index
            else if (thiefIndices.get(thiefIndex) < policeIndices.get(policeIndex)) {
                thiefIndex++;
            } else {
                policeIndex++;
            }
        }
        return maxNumberOfCatches;
    }

}

