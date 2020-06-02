package com.eknv.algorithms.dynamic;

/**
 * Count number of ways to reach n't stair when
 * a person can climb 1, 2, ..m stairs at a time
 */
public class StaircaseCount {

    private StaircaseCount() {
    }

    /**
     * number of ways to reach n't stair when
     *
     * @param steps number of steps
     * @param jumps can climb 1, 2, ..m stairs at a time
     * @return
     */
    public static int calculate(int steps, int jumps) {

        int[] jumpPossibilities = new int[steps + 1];

        /**
         * initialize the step 0 with 1
         * it is necessary for the further calculations
         */
        jumpPossibilities[0] = 1;

        for (int s = 1; s <= steps; s++) {
            for (int j = 1; j <= jumps && j <= s; j++) {
                jumpPossibilities[s] += jumpPossibilities[s - j];
            }
        }

        return jumpPossibilities[steps];
    }

} 
