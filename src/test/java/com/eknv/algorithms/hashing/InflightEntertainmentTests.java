package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.hashing.InflightEntertainment.canTwoMoviesFillFlight;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class InflightEntertainmentTests {


    @Test
    public void shortFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{2, 4}, 1);
        assertFalse(result);
    }

    @Test
    public void longFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{2, 4}, 6);
        assertTrue(result);
    }

    @Test
    public void onlyOneMovieHalfFlightLenghtTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{3, 8}, 6);
        assertFalse(result);
    }

    @Test
    public void twoMoviesHalfFlightLengthTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{3, 8, 3}, 6);
        assertTrue(result);
    }

    @Test
    public void lotsOfPossiblePairsTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{1, 2, 3, 4, 5, 6}, 7);
        assertTrue(result);
    }

    @Test
    public void notUsingFirstMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{4, 3, 2}, 5);
        assertTrue(result);
    }

    @Test
    public void oneMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{}, 6);
        assertFalse(result);
    }

}