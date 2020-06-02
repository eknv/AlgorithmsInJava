package com.eknv.algorithms.divide_conquer;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * calculate the value x power to y
 * note that x can be float and y can also be a negative value
 */
public class PowerTo {

    private PowerTo() {
    }

    public static BigDecimal execute(double x, int y) {

        BigDecimal temp;

        if (y == 0) {
            return BigDecimal.ONE;
        }

        temp = execute(x, y / 2);

        /**
         * if y is dividable by 2
         */
        if (y % 2 == 0) {
            return temp.multiply(temp);
        }
        /**
         * otherwise
         */
        else if (y > 0) {
            return temp.multiply(temp).multiply(BigDecimal.valueOf(x));
        } else {
            return temp.multiply(temp).divide(BigDecimal.valueOf(x), MathContext.DECIMAL128);
        }

    }

}
