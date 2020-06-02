package com.eknv.algorithms.dynamic;

/**
 * Given a non-negative index k where k<=33, return k-th index row of the pascal triangle
 * Note that the row index start from 0
 */
public class PascalTriangle {

    private PascalTriangle() {
    }

    public static int[] calculate(int rowIndex) {

        if (rowIndex > 33) {
            throw new IllegalArgumentException("RowIndex should be in the range of 0 to 33");
        }

        int[] prevArr = new int[]{1};
        int[] arr = prevArr;

        for (int i = 1; i <= rowIndex; i++) {
            arr = new int[i + 1];
            arr[0] = 1;
            arr[arr.length - 1] = 1;
            for (int j = 1; j < arr.length - 1; j++) {
                arr[j] = prevArr[j - 1] + prevArr[j];
            }
            prevArr = arr;
        }

        return arr;
    }

} 
