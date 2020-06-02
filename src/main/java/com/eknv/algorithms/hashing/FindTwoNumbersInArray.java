package com.eknv.algorithms.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTwoNumbersInArray {

    private FindTwoNumbersInArray() {
    }

    public static List<Integer> execute(int[] nums, int targetSum) {
        Set<Integer> alreadyEncountered = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int complement = targetSum - currentValue;
            if (alreadyEncountered.contains(complement)) {
                return Arrays.asList(currentValue, complement);
            }
            alreadyEncountered.add(currentValue);
        }

        throw new IllegalStateException("No solution could be found.");
    }

}
