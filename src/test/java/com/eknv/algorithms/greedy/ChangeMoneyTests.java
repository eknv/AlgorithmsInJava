package com.eknv.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ChangeMoneyTests {


    @Test
    public void test() {

        assertArrayEquals(new int[]{4, 0, 0, 0, 0, 1}, ChangeMoney.calculate(5, 0.99));


    }

}
