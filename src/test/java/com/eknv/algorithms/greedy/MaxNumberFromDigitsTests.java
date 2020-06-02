package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumberFromDigitsTests {

    @Test
    public void test() {

        assertEquals(987633320, MaxNumberFromDigits.calculate(382903367));
    }

}