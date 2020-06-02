package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindClosestNumberTests {

    @Test
    public void test1() {

        assertEquals(9, FindClosestNumber.execute(new int[]{1, 2, 4, 5, 6, 6, 8, 9}, 11));
        assertEquals(1, FindClosestNumber.execute(new int[]{1, 2, 4, 5, 6, 6, 8, 9}, -1));

        assertEquals(3, FindClosestNumber.execute(new int[]{1, 2, 3, 6, 6, 8, 9}, 4));
        assertEquals(6, FindClosestNumber.execute(new int[]{1, 2, 3, 6, 6, 8, 9}, 5));

    }


}



