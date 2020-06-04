package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MinStringCompressionSizeTests {


    @Test
    public void test() {

        assertEquals(2, MinStringCompressionSize.calculate("AAAAA", 3));

        assertEquals(5, MinStringCompressionSize.calculate("AAAAAabc", 3));

        assertEquals(2, MinStringCompressionSize.calculate("AAAAAabcA", 3));

        assertEquals(3, MinStringCompressionSize.calculate("XAAAAAabcA", 3));

        assertEquals(3, MinStringCompressionSize.calculate("AAAAAAAAAAxedAA", 3));

        assertEquals(11, MinStringCompressionSize.calculate("AAAAAAAAAAxedAAAAAAAAAABBtxzuBBBBB", 3));

        assertEquals(12, MinStringCompressionSize.calculate("AAAAAAAAAAxedAAAAAAAAAABBBBBBBBBBtxzuBBBBBBBBB", 3));

        assertEquals(13, MinStringCompressionSize.calculate("AAAAAAAAAAxedAAAAAAAAAABBBBBBBBBBtxzuBBBBBBBBBB", 3));

        assertEquals(12, MinStringCompressionSize.calculate("AAAAAAAAAAxedAAAAAAAAAABBBBBBBBBBtxzuBBBBBBBBBB", 4));
    }

}