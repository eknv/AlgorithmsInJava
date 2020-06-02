package com.eknv.algorithms.dynamic;


/**
 * Given a certain amount of floors of a building (say f number of floors)
 * and also given certain amount of eggs (say e number of eggs)
 * <p>
 * What is the least amount of egg drops one has to perform to find out the threshold floor?
 * <p>
 * Threshold floor is one from which the egg starts breaking and also egg breaks for all the floors above.
 * Also, if egg dropped from any floor below the threshold floor, it won’t break.
 * <p>
 * Constraints:
 * - An egg that survives a fall can be used again.
 * - A broken egg must be discarded.
 * - The effect of a fall is the same for all eggs.
 * - If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * - If an egg survives a fall then it would survive a shorter fall.
 * <p>
 */
public class LeastAmountOfEggDrops {

    private LeastAmountOfEggDrops() {
    }

    public static int calculate(int nrOfFloors, int nrOfEggs) {

        int[][] matrix = new int[nrOfFloors + 1][nrOfEggs + 1];

        for (int i = 1; i <= nrOfEggs; i++) {
            // 0 floor -> 0 try
            matrix[0][i] = 0;
            // 1 floor -> 1 try no matter how many eggs
            matrix[1][i] = 1;
        }

        /**
         * with one egg, we have to try for the number of floors
         */
        for (int i = 1; i <= nrOfFloors; i++) {
            matrix[i][1] = i;
        }

        for (int e = 2; e <= nrOfEggs; e++) {

            for (int f = 2; f <= nrOfFloors; f++) {

                matrix[f][e] = Integer.MAX_VALUE;

                /**
                 * for each floor we go through all the floors and apply the following logic
                 * - if the egg breaks at a floor, then we should go down (subproblem 1)
                 * - if the egg does not break at a floor, then we should go up (subproblem 2)
                 * here we have in each floor two subproblems and we need the max value between these two sub-problems
                 * because we are looking for the worst case scenario
                 *
                 * after we have the number of possibilities for each floor up to the top floor
                 * then we look for the smallest value between all the floor we have calculated previously
                 * here are we looking for the floor on which we should start dropping the eggs so that
                 * we need the least amount of attempts
                 */
                for (int k = 1; k <= f; k++) {
                    matrix[f][e] = Math.min(
                            matrix[f][e],
                            1 + Math.max(
                                    /**
                                     * egg breaks
                                     * gotta go down k-1 floors to go
                                     * and we have one egg less now
                                     */
                                    matrix[k - 1][e - 1],
                                    /**
                                     * egg does not break
                                     * we go up f-k floors to the top
                                     * and keep all eggs
                                     */
                                    matrix[f - k][e]
                            )
                    );
                }

            }
        }

        return matrix[nrOfFloors][nrOfEggs];
    }

}
