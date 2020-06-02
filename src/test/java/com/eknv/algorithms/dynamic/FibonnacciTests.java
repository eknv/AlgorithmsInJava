package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonnacciTests {

    @Test
    void test1() {

        assertThrows(Exception.class, () -> Fibonnacci.calculate(-1));

        assertEquals(0, Fibonnacci.calculate(0));
        assertEquals(1, Fibonnacci.calculate(1));

        assertEquals(55, Fibonnacci.calculate(10));

    }

}
