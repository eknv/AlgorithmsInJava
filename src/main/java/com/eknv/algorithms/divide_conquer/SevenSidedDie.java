package com.eknv.algorithms.divide_conquer;

import java.security.SecureRandom;

/**
 * You have a function rand5() that generates a random integer from 1 to 5.
 * Use it to write a function rand7() that generates a random integer from 1 to 7.
 * rand5() returns each integer with equal probability.
 * rand7() must also return each integer with equal probability.
 */
public class SevenSidedDie {

    private SevenSidedDie() {
    }

    /**
     * in this implementation each number has a 7/35 = 1/5 chance of appearing
     */
    public static int execute() {
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += rand5();
        }
        return sum % 7;
    }

    private static int rand5() {
        return 1 + new SecureRandom().nextInt(5);
    }

}
