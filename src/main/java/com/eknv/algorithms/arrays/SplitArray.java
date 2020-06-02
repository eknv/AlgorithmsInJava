package com.eknv.algorithms.arrays;

/**
 * Write a function that takes an array of integers (arr), and an integer (x).
 * You need to find the position in arr that splits the array in two,
 * where one side has as many occurrences of x as the other side has occurrences of any number but x
 * <p>
 * So, given an array like this: [5, 5, 2, 3, 5, 1, 6] and x being "5",
 * the function should return "4" (Position 4, holding the number "3"
 * above is the point where you have 2 5's on the one side, and two "not fives" on the other.
 */
public class SplitArray {


    private SplitArray() {
    }

    public static int calculate(int[] arr, int x) {


        int i = 0;
        int j = arr.length - 1;
        int firstHalfCount = 0;
        int secondHalfCount = 0;


        while (i < j) {

            while (arr[i++] != x && i < j - 1) {
                // do nothing
            }
            firstHalfCount++;

            while (arr[j--] == x && i < j - 1) {
                // do nothing
            }
            secondHalfCount++;
        }

        if (firstHalfCount != secondHalfCount) {
            return -1;
        }

        return j;
    }


}


