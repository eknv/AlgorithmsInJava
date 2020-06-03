package com.eknv.algorithms.divide_conquer;

import com.eknv.util.Utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * You have a function rand5() that generates a random integer from 1 to 5.
 * Use it to write a function rand7() that generates a random integer from 1 to 7.
 * rand5() returns each integer with equal probability.
 * rand7() must also return each integer with equal probability.
 */
public class SevenSidedDie {

    private static Random random = new SecureRandom();

    private SevenSidedDie() {
    }

    /**
     * in this implementation each number has a 7/35 = 1/5 chance of appearing
     */
    public static int execute() {

        /**
         * we throw the die twice
         * there 25 possibilities though and it is not dividable by 7
         * for that reason, we take the following formula to get numbers
         * in the range 1-21: (rand5-1)*5 + rand5
         */
        while (true) {
            int between1and25 =
                    Utils.multiply((rand5() - 1), 5) + // between 0-20
                            rand5(); // between 1-5
            if (between1and25 > 21) {
                continue;
            }
            return (between1and25 % 7) + 1;
        }
    }

    private static int rand5() {
        return 1 + random.nextInt(5);
    }

}
