package com.eknv.algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.eknv.algorithms.arrays.ReverseStringInPlace.reverse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ReverseStringInPlaceTests {


    @Test
    public void emptyStringTest() {
        final char[] actual = "".toCharArray();
        reverse(actual);
        final char[] expected = "".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] actual = "A".toCharArray();
        reverse(actual);
        final char[] expected = "A".toCharArray();
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        final char[] expected = "EDCBA".toCharArray();
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

}
