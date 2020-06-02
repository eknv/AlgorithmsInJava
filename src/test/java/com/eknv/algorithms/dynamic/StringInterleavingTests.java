package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringInterleavingTests {

    @Test
    void testDynamic() {

        assertEquals(false, StringInterleaving.calculate("XXY", "XXZ", "XXZXXXY"));
        assertEquals(false, StringInterleaving.calculate("XXZ", "XXY", "XXZXXXY"));

        assertEquals(true, StringInterleaving.calculate("XY", "WZ", "WZXY"));
        assertEquals(true, StringInterleaving.calculate("WZ", "XY", "WZXY"));

        assertEquals(true, StringInterleaving.calculate("XY", "X", "XXY"));
        assertEquals(true, StringInterleaving.calculate("X", "XY", "XXY"));

        assertEquals(false, StringInterleaving.calculate("YX", "X", "XXY"));
        assertEquals(false, StringInterleaving.calculate("X", "YX", "XXY"));

        assertEquals(true, StringInterleaving.calculate("XXY", "XXZ", "XXXXZY"));
        assertEquals(true, StringInterleaving.calculate("XXZ", "XXY", "XXXXZY"));

        assertEquals(true, StringInterleaving.calculate("abd", "cef", "abcdef"));
        assertEquals(true, StringInterleaving.calculate("cef", "abd", "abcdef"));

        assertEquals(false, StringInterleaving.calculate("aabcc", "dbbca", "aadbbbaccc"));
        assertEquals(false, StringInterleaving.calculate("dbbca", "aabcc", "aadbbbaccc"));

        assertEquals(true, StringInterleaving.calculate("aabcc", "dbbca", "aadbbcbcac"));
        assertEquals(true, StringInterleaving.calculate("dbbca", "aabcc", "aadbbcbcac"));

    }

}
