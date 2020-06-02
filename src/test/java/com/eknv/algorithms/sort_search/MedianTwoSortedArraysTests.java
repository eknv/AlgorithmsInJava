package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianTwoSortedArraysTests {


    @Test
    void test1() {

        assertEquals(13.5, MedianTwoSortedArrays.calculate(new int[]{900}, new int[]{10, 13, 14}));

    }

    @Test
    void test2() {

        assertEquals(16, MedianTwoSortedArrays2.calculate(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45}));

        Exception exception = assertThrows(RuntimeException.class, () -> MedianTwoSortedArrays2.calculate(new int[]{900}, new int[]{10, 13, 14}));
        assertEquals("Both arrays should have the length", exception.getMessage());

    }


}
