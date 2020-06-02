package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeastAmountOfEggDropsTests {


    @Test
    void test1() {

        assertEquals(4, LeastAmountOfEggDrops.calculate(15, 6));
        assertEquals(8, LeastAmountOfEggDrops.calculate(36, 2));
        assertEquals(4, LeastAmountOfEggDrops.calculate(10, 2));

    }

}
