package com.eknv.algorithms.sort_search;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Note, in this implementation,
 * the values in the array should not exceed the size of the array
 */
public class FindDuplicatesInArray3 {

    private FindDuplicatesInArray3() {
    }

    public static List<Integer> execute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Assert.isTrue(arr[i] < arr.length,
                    "The values in the array cannot be bigger than the size of the array");
        }
        return exe(arr);
    }

    private static List<Integer> exe(int[] arr) {

        List<Integer> duplicates = new ArrayList<>();

        int arrayLength = arr.length;

        for (int i = 0; i < arrayLength; i++) {
            int currentValue = arr[i];
            arr[currentValue % arrayLength] = arr[currentValue % arrayLength] + arrayLength;
        }

        for (int i = 0; i < arrayLength; i++) {
            if (arr[i] >= arrayLength * 2) {
                duplicates.add(i);
            }
        }

        return duplicates;
    }

}
