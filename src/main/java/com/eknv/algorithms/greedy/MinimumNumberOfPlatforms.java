package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * Returns minimum number of platforms required
 */
public class MinimumNumberOfPlatforms {

    private MinimumNumberOfPlatforms() {
    }

    public static int calculate(int[] arrivals, int[] departures) {

        Assert.isTrue(arrivals.length == departures.length, "arrivals.length == departures.length");

        int length = arrivals.length;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int maxNeededPlatforms = 1;
        int currentlyNeededPlatforms = 1;
        int arrivalIndex = 1;
        int departureIndex = 0;

        while (arrivalIndex < length && departureIndex < length) {
            if (arrivals[arrivalIndex] <= departures[departureIndex]) {
                arrivalIndex++;
                currentlyNeededPlatforms++;
                if (currentlyNeededPlatforms > maxNeededPlatforms) {
                    maxNeededPlatforms = currentlyNeededPlatforms;
                }
            } else {
                departureIndex++;
                currentlyNeededPlatforms--;
            }
        }

        return maxNeededPlatforms;
    }

} 
