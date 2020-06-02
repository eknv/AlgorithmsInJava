package com.eknv.algorithms.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConvertMaxHeap2MinHeapTests {

    @Test
    public void test() {
        assertArrayEquals(new int[]{11, 9, 5, 4, -2, 4, 3},
                ConvertMaxHeap2MinHeap.execute(new int[]{9, 4, 3, 11, -2, 4, 5}));
    }

}