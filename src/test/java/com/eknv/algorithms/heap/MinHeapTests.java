package com.eknv.algorithms.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinHeapTests {

    @Test
    public void test() {
        assertArrayEquals(new int[]{2, 3, 7, 11, 15, 14, 9, 12, 31, 16},
                new MinHeap(31, 11, 7, 12, 15, 14, 9, 2, 3, 16).asArray());
    }

}