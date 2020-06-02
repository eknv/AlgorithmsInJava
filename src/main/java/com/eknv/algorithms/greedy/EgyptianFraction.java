package com.eknv.algorithms.greedy;

import com.eknv.util.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Print a fraction for the given nominator and denominator in Egyptian form using Greedy Algorithm
 * <p>
 * Every positive fraction can be represented as sum of unique unit fractions.
 * A fraction is unit fraction if numerator is 1 and denominator is a positive integer, for example 1/3 is a unit fraction.
 * Such a representation is called Egyptian Fraction as it was used by ancient Egyptians.
 */
public class EgyptianFraction {

    private EgyptianFraction() {
    }

    public static List<String> printEgyptian(int nominator, int denominator) {

        List<String> parts = new ArrayList<>();

        /**
         * if either numerator or denominator is 0
         * return empty
         */
        if (denominator == 0 || nominator == 0) {
            return parts;
        }

        /**
         * if numerator divides denominator
         * then simple division makes the fraction in 1/n form
         */
        if (denominator % nominator == 0) {
            parts.add("1/" + denominator / nominator);
            return parts;
        }

        /**
         * if denominator divides numerator
         * then the given number is not fraction
         */
        if (nominator % denominator == 0) {
            parts.add("" + nominator / denominator);
            return parts;
        }

        /**
         * in case numerator is bigger than the denominator
         */
        if (nominator > denominator) {
            parts.add("" + nominator / denominator);
            parts.addAll(printEgyptian(nominator % denominator, denominator));
            return parts;
        }

        /**
         * if we reach here
         * - dr > nr
         * - dr % nr is non-zero
         * then find the ceiling of dr/nr and add it as a fraction
         */
        int n = (int) Math.ceil(Utils.divide(denominator, nominator));
        parts.add("1/" + n);

        /**
         * recur for the remaining part
         */
        parts.addAll(printEgyptian(nominator * n - denominator, denominator * n));

        return parts;
    }
}

