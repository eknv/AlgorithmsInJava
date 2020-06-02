package com.eknv.algorithms.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxHeapTests {

    @Test
    public void test() {
        assertArrayEquals(new int[]{16, 15, 14, 12, 4, 7, 9, 2, 3, 1},
                MaxHeap.buildMaxHeap(new int[]{1, 4, 7, 12, 15, 14, 9, 2, 3, 16}));
    }

}