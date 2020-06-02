package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliceCatchThiefTests {

    @Test
    public void test() {
        assertEquals(2, PoliceCatchThief.calculate(new char[]{'P', 'T', 'T', 'P', 'T'}, 2));
        assertEquals(2, PoliceCatchThief.calculate(new char[]{'T', 'T', 'P', 'P', 'T', 'P'}, 1));
        assertEquals(2, PoliceCatchThief.calculate(new char[]{'P', 'T', 'P', 'T', 'T', 'T'}, 1));
    }

}