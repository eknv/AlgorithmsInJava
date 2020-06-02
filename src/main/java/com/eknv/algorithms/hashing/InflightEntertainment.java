package com.eknv.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * You've built an inflight entertainment system with on-demand movie streaming.
 * <p>
 * Users on longer flights like to start a second movie right when their first one ends,
 * but they complain that the plane usually lands before they can see the ending.
 * So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.
 * <p>
 * Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes)
 * and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.
 * <p>
 * When building your method:
 * <p>
 * Assume your users will watch exactly two movies
 * Don't make your users watch the same movie twice
 * Optimize for runtime over memory
 */
public class InflightEntertainment {


    private InflightEntertainment() {
    }

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        Set<Integer> existingLengths = new HashSet<>();

        for (int i = 0; i < movieLengths.length; i++) {

            int currentMovieLength = movieLengths[i];
            int missingLength = flightLength - currentMovieLength;
            if (existingLengths.contains(missingLength)) {
                return true;
            } else {
                existingLengths.add(currentMovieLength);
            }
        }

        return false;
    }


}