package com.eknv.algorithms.arrays;

import org.springframework.util.Assert;

/**
 * Given a sorted list of positive numbers, find the smallest positive number that cannot be a sum of any subset in the list.
 * <p>
 * Example:
 * <p>
 * Input: [1, 2, 3, 8, 9, 10]
 * Output: 7
 * <p>
 * Numbers 1 to 6 can all be summed by a subset of the list of numbers, but 7 cannot.
 */
public class SmallestNumberNotSumOfSubset {


    private SmallestNumberNotSumOfSubset() {
    }

    public static int calculate(int[] numbers) {

        Assert.notNull(numbers, "numbers");

        if (numbers.length == 0) {
            throw new IllegalArgumentException("The list cannot be empty");
        }

        validateIsSorted(numbers);

        if (numbers[0] != 1) {
            return 1;
        }

        for (int i = 0; i < numbers.length; i++) {

            int currentNumber = numbers[i];

            /**
             * if the next sequential number is not in the list
             */

            while ((i != numbers.length - 1 && ++currentNumber < numbers[i + 1])
                    || (i == numbers.length - 1 && ++currentNumber > numbers[i])) {
                boolean inSubset = isInSubset(numbers, 0, i, currentNumber);
                if (!inSubset) {
                    return currentNumber;
                }
            }
        }

        return -1;
    }


    /**
     * checks if the given number can be put together with the numbers in the given array subset
     *
     * @param numbers
     * @param startIndex
     * @param endIndex
     * @param nextNumber
     * @return
     */
    private static boolean isInSubset(int[] numbers, int startIndex, int endIndex, int nextNumber) {

        int remainingNumber = nextNumber;
        for (int i = endIndex; i >= startIndex; i--) {
            if (remainingNumber >= numbers[i]) {
                remainingNumber -= numbers[i];
            }
            /**
             * we could already get the nextNumber by adding some numbers in the given array subset
             */
            if (remainingNumber == 0) {
                break;
            }
        }

        return remainingNumber == 0;
    }


    private static void validateIsSorted(int[] numbers) {

        int prevValue = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] < prevValue) {
                throw new IllegalArgumentException("This array is not sorted");
            } else {
                prevValue = numbers[i];
            }

        }

    }

}
