package com.eknv.algorithms.greedy;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the Largest number with given number of digits and sum of digits
 * <p>
 * Input  : s = 9, d = 2
 * Output : 90
 * <p>
 * Input  : s = 20, d = 3
 * Output : 992
 */
public class FindLargestNumberWithDigitsNSum {

    private FindLargestNumberWithDigitsNSum() {
    }

    public static String calculate(int numberOfDigits, int sumValue) {

        List<String> digits = new ArrayList<>();

        /**
         * If sum of digits is 0, then a number is possible
         * only if number of digits is 1
         */
        if (sumValue == 0) {
            if (numberOfDigits == 1) {
                return "0";
            } else {
                throw new IllegalArgumentException("For a sum of 0, the number of digits should be 1");
            }
        }

        // Sum greater than the maximum possible sum
        if (sumValue > 9 * numberOfDigits) {
            throw new IllegalArgumentException("With the given digits, it is not possible to create the requested sum value");
        }


        // fill from most significant digit to least significant digit
        for (int i = 0; i < numberOfDigits; i++) {
            // fill 9 first to make the number largest
            if (sumValue >= 9) {
                digits.add("9");
                sumValue -= 9;
            }

            // If remaining sum becomes less than 9, then
            // fill the remaining sum
            else {
                digits.add("" + sumValue);
                sumValue = 0;
            }
        }

        return digits.stream().collect(Collectors.joining(""));
    }

}

