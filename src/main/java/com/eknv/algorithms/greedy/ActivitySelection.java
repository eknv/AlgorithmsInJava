package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate a maximum set of activities that can be done by a single
 * person, one at a time.
 * <p>
 * The following implementation assumes that the activities
 * are already sorted according to their finish time
 */
public class ActivitySelection {


    private ActivitySelection() {
    }

    public static List<Integer> calculate(int[] start, int[] finish) {

        Assert.notNull(start, "start");
        Assert.notNull(finish, "finish");

        Assert.isTrue(start.length == finish.length, "start.length == finish.length");

        List<Integer> selectedActivities = new ArrayList<>();

        int i = 0;
        selectedActivities.add(i);

        /**
         * go through the rest of the activities
         */
        for (int j = 1; j < start.length; j++) {
            /**
             * if the current activity has start time greater than or
             * equal to the finish time of the previously selected one
             */
            if (start[j] >= finish[i]) {
                selectedActivities.add(j);
                i = j;
            }
        }

        return selectedActivities;
    }

} 
