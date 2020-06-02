package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopScoresTests {

    @Test
    public void noScoresTest() {
        final int[] scores = {};
        final int[] expected = {};
        final int[] actual = TopScores.calculate(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneScoreTest() {
        final int[] scores = {55};
        final int[] expected = {55};
        final int[] actual = TopScores.calculate(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoScoresTest() {
        final int[] scores = {30, 60};
        final int[] expected = {60, 30};
        final int[] actual = TopScores.calculate(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyScoresTest() {
        final int[] scores = {37, 89, 41, 65, 91, 53};
        final int[] expected = {91, 89, 65, 53, 41, 37};
        final int[] actual = TopScores.calculate(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void repeatedScoresTest() {
        final int[] scores = {20, 10, 30, 30, 10, 20};
        final int[] expected = {30, 30, 20, 20, 10, 10};
        final int[] actual = TopScores.calculate(scores, 100);
        assertArrayEquals(expected, actual);
    }

}