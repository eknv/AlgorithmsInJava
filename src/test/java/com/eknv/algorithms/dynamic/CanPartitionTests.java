package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanPartitionTests {

    @Test
    void test1() {

        assertEquals(true, CanPartition.calculate(new int[]{1, 2, 3, 4}));

        assertEquals(true, CanPartition.calculate(new int[]{1, 1, 3, 4, 7}));

        assertEquals(false, CanPartition.calculate(new int[]{2, 3, 4, 6}));

        assertEquals(false, CanPartition.calculate(new int[]{2, 8, 2, 6}));

        assertEquals(true, CanPartition.calculate(new int[]{3, 1, 3, 10, 4, 5}));

        assertEquals(true, CanPartition.calculate(new int[]{1, 5, 11, 5}));

        assertEquals(true, CanPartition.calculate(new int[]{3, 1, 1, 2, 2, 1}));

        assertEquals(true, CanPartition.calculate(new int[]{1, 1}));

    }


}
