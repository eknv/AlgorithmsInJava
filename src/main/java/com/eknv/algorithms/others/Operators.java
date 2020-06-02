package com.eknv.algorithms.others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operators {

    private static Logger logger = LoggerFactory.getLogger(Operators.class);

    private Operators() {
    }

    /**
     * Bitwise operators
     */
    public static void bitwiseOperators(int a, int b) {

        // bitwise and
        // 0101 & 0111=0101 = 5
        logger.debug("{} & {} = {}", "0101", "0111", "0101");
        logger.debug("{} & {} = {}", a, b, (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        logger.debug("a|b = {}", (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        logger.debug("a^b = {}", (a ^ b));

        // bitwise NOT
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        logger.debug("~a = {}", ~a);


        a &= b;
        logger.debug("a= {}", a);
    }

    /**
     * Shift operators
     */
    public static void shiftOperators(int a, int b, int c) {

        // left shift operator
        // 0000 0101<<2 =0001 0100(20)
        // similar to 5*(2^2)
        logger.debug("a<<2 = {}", (a << 2));

        // right shift operator
        // 0000 0101 >> 2 =0000 0001(1)
        // similar to 5/(2^2)
        logger.debug("b>>2 = {}", (b >> 2));

        // unsigned right shift operator
        logger.debug("b>>>2 = {}", (b >>> 2));


        /**
         * Using unsigned right shift with negative number in Java
         * we can use binary literals from JDK 1.7 to assign
         * binary values to an integer, 0b is for binary, similar to 0x of hexadecimal
         */
        String cAsBinary = Integer.toBinaryString(c);
        logger.debug("Before unsigned right shift : {}", cAsBinary);
        logger.debug("number in decimal format : {}", c);

        /**
         * shift 1 bit using right shift without sign
         */
        c = c >>> 1;

        String cAsBinaryAfterwards = Integer.toBinaryString(c);
        logger.debug("After unsigned right shift : {}", cAsBinaryAfterwards);
        logger.debug("number in decimal format : {}", c);

    }


    public static void main(String[] args) {

        logger.debug("Bitwise operators: a = {}, b = {} ", 5, 7);
        Operators.bitwiseOperators(5, 7);

        logger.debug("Shift operators: {}, {}, {}",
                5, -10, "0b1111_1000_1111_1010_1111_1000_1111_1010");
        Operators.shiftOperators(5, -10, 0b1111_1000_1111_1010_1111_1000_1111_1010);

    }

}


