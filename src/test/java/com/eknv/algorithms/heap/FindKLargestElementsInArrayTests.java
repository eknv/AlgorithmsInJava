package com.eknv.algorithms.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindKLargestElementsInArrayTests {

    @Test
    public void test() {
        assertArrayEquals(new int[]{9, 7},
                FindKLargestElementsInArray.calculate(new int[]{9, 4, 7, 1, -2, 6, 5}, 2));
    }

}