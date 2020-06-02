package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShuffleArrayTests {

    @Test
    public void notEqual() {
        assertNotEquals("[1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(ShuffleArray.execute(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
    }

    @Test
    public void allEntriesRemain() {
        int[] shuffledArray = ShuffleArray.execute(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        Set<Integer> set = new HashSet<>();
        Arrays.stream(shuffledArray).forEach(set::add);
        assertEquals(shuffledArray.length, set.size());
    }

}