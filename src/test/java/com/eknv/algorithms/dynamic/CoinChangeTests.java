package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoinChangeTests {


    @Test
    void test1() {

        assertEquals(4, CoinChange.calculate(10, new int[]{1, 5, 10, 25}));
        assertEquals(4, CoinChange.calculate(4, new int[]{1, 2, 3}));
        assertEquals(5, CoinChange.calculate(10, new int[]{2, 5, 3, 6}));

        assertThrows(Exception.class, () -> CoinChange.calculate(10, new int[]{}));

    }

}
