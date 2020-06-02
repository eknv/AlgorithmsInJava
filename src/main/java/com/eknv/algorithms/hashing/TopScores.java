package com.eknv.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * You created a game that is more popular than Angry Birds.
 * <p>
 * Each round, players receive a score between 0 and 100, which you use to rank them from highest to lowest.
 * So far you're using an algorithm that sorts in O(nlg⁡n) time,
 * but players are complaining that their rankings aren't updated fast enough.
 * You need a faster sorting algorithm.
 * <p>
 * Write a method that takes:
 * <p>
 * an array of unsortedScores
 * the highestPossibleScore in the game
 * <p>~
 * and returns a sorted array of scores in less than O(nlg⁡n)O(n\lg{n})O(nlgn) time.
 * <p>
 * For example:
 * <p>
 * int[] unsortedScores = {37, 89, 41, 65, 91, 53};
 * final int HIGHEST_POSSIBLE_SCORE = 100;
 * <p>
 * int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
 * // sortedScores: [91, 89, 65, 53, 41, 37]
 * <p>
 * We’re defining nnn as the number of unsortedScores because we’re expecting the number of players to keep climbing.
 * <p>
 * And, we'll treat highestPossibleScore as a constant instead of factoring it into our big O time and space costs
 * because the highest possible score isn’t going to change.
 * Even if we do redesign the game a little, the scores will stay around the same order of magnitude.
 * <p>
 * Do you have an answer?
 */
public class TopScores {

    private TopScores() {
    }

    public static int[] calculate(int[] unorderedScores, int highestPossibleScore) {

        /**
         * sort the scores in O(n) time
         */
        Map<Integer, Integer> scoresCount = new HashMap<>();


        for (int i = 0; i < unorderedScores.length; i++) {
            scoresCount.compute(unorderedScores[i], (key, value) -> value == null ? 1 : ++value);
        }

        int j = 0;
        int[] results = new int[unorderedScores.length];
        for (int score = highestPossibleScore; score >= 0; score--) {
            Integer count = scoresCount.getOrDefault(score, 0);
            while (count > 0) {
                results[j] = score;
                count--;
                j++;
            }
        }

        return results;
    }

}
