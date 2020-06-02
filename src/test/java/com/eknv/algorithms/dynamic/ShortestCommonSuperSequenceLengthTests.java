package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * the shortest string that contains the given two strings
 */
public class ShortestCommonSuperSequenceLengthTests {


    @Test
    void test1() {

        assertEquals(5, ShortestCommonSuperSequenceLength.calculate("abcf", "bdcf"));

    }


}
