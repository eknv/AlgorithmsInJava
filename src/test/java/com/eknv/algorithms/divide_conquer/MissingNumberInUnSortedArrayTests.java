package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MissingNumberInUnSortedArrayTests {

    @Test
    public void test1() {

        assertEquals(3, MissingNumberInUnsortedArray.execute(new int[]{0, 10, 2, -10, 1, -20}));

    }

}



