package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubstringTest {

    @Test
    void test1() {

        assertEquals("bcd", LongestCommonSubstring.calculate("abcdefg", "xyzdebcd"));
        assertEquals("pute", LongestCommonSubstring.calculate("computerscience", "erscpute"));
        assertEquals("ersci", LongestCommonSubstring.calculate("computerscience", "erscipute"));

    }

}
