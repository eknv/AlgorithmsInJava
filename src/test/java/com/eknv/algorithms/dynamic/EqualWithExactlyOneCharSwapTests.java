package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqualWithExactlyOneCharSwapTests {


    @Test
    void test1() {

        assertEquals(true, EqualWithExactlyOneCharSwap.calculate("ab", "ba"));

    }

    @Test
    void equalStrings1() {

        assertEquals(false, EqualWithExactlyOneCharSwap.calculate("aa", "aa"));

    }

    @Test
    void equalStrings2() {

        assertEquals(false, EqualWithExactlyOneCharSwap.calculate("ab", "ab"));

    }


    @Test
    void test2() {

        assertEquals(true, EqualWithExactlyOneCharSwap.calculate("aaaaaaabc", "aaaaaaacb"));

    }


    @Test
    void twoSwapsNecessary() {

        assertEquals(false, EqualWithExactlyOneCharSwap.calculate("xyaaaaabc", "yxaaaaacb"));

    }


    @Test
    void unequalSizes() {

        assertEquals(false, EqualWithExactlyOneCharSwap.calculate("", "a"));
        assertEquals(false, EqualWithExactlyOneCharSwap.calculate("", "aa"));


    }
}
