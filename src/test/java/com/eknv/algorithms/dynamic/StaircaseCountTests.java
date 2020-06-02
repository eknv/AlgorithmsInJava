package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaircaseCountTests {

    @Test
    void test() {

        assertEquals(5, StaircaseCount.calculate(4, 2));
        assertEquals(81, StaircaseCount.calculate(8, 3));
        assertEquals(7, StaircaseCount.calculate(4, 3));
        assertEquals(13, StaircaseCount.calculate(5, 3));

    }


}
