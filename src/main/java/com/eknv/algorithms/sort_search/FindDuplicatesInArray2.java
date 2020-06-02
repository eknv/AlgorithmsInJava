package com.eknv.algorithms.sort_search;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Java code to find duplicates in O(n) time
 * <p>
 * Note, in this implementation, the values in the array should not exceed the size of the array
 */
public class FindDuplicatesInArray2 {

    private FindDuplicatesInArray2() {
    }

    public static List<Integer> execute(int[] arr) {

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            Assert.isTrue(arr[i] < arr.length,
                    "The values in the array cannot be bigger than the size of the array");

            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                duplicates.add(Math.abs(arr[i]));
            }
        }

        return duplicates;
    }
}

