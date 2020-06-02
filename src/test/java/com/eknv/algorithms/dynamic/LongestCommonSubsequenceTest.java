package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubsequenceTest {

    @Test
    void test1() {

        assertEquals("bcf", LongestCommonSubsequence.calculate("abcf", "bdcf"));

    }

}
