package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectCoinsTests {

    @Test
    public void test() {
        assertEquals("[50, 20, 10, 5, 1, 1, 1]", SelectCoins.selectCoins(new int[]{1, 5, 10, 20, 50}, 88).toString());
    }

}