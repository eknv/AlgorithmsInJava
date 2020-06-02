package com.eknv.algorithms.others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Convert n into negative base for
 */
public class NegativeBase {

    private static Logger logger = LoggerFactory.getLogger(NegativeBase.class);

    private NegativeBase() {
    }

    /**
     * convert number to base negBase
     */
    public static String calculate(int number, int negBase) {

        /**
         * if n is zero, then in any base it will be 0
         */
        if (number == 0) {
            return "0";
        }

        StringBuilder converted = new StringBuilder();

        while (number != 0) {
            /**
             * Get remainder by negative base
             * it can be negative also
             */
            int remainder = number % negBase;
            number /= negBase;

            logger.trace("  Nr: {}, Remainder: {}", number, remainder);


            /**
             * if remainder is negative,
             * add Math.abs(base) to it
             * and add 1 to n
             */
            if (remainder < 0) {
                remainder += (-negBase);
                number += 1;
                logger.trace("    Nr: {}, Remainder: {}", number, remainder);
            }

            converted.insert(0, remainder);
        }

        return converted.toString();
    }

}

