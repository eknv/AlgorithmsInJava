package com.eknv.algorithms.dynamic;


/**
 * The Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. #
 * That is: F0 = 0 , F1 = 1 and Fn = Fn−1 + Fn−2
 */
class Fibonnacci {

    private Fibonnacci() {
    }

    public static int calculate(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed!");
        }

        if (number <= 1) {
            return number;
        }

        int[] fibs = new int[number + 1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[number];
    }

} 
