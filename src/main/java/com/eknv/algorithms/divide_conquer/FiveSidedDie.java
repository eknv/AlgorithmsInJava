package com.eknv.algorithms.divide_conquer;

import java.security.SecureRandom;

/**
 * You have a function rand7() that generates a random integer from 1 to 7.
 * Use it to write a function rand5() that generates a random integer from 1 to 5.
 * rand7() returns each integer with equal probability.
 * rand5() must also return each integer with equal probability.
 */
public class FiveSidedDie {

    private FiveSidedDie() {
    }

    /**
     * in this implementation each number has a 1/7 chance of appearing
     * and there is a very slight possibility that this method does never return
     */
    public static int execute() {
        int number = rand7();
        while (number > 5) {
            number = rand7();
        }
        return number;
    }


    /**
     * this implementation is faster but there is a slight difference
     * between the possibilities of getting each number
     */
    public static int execute2() {

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += rand7();
        }

        return 1 + (sum % 5);
    }

    private static int rand7() {
        return 1 + new SecureRandom().nextInt(7);
    }

}
