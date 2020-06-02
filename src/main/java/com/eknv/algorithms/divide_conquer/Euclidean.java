package com.eknv.algorithms.divide_conquer;

/**
 * The Euclidean algorithm is a technique used to compute the greatest common divisor (GCD) of two numbers,
 * i.e. the largest number that divides both of them without leaving a remainder.
 */
public class Euclidean {

    private Euclidean() {
    }


    /**
     * calculate greatest common divisor
     */
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

}

