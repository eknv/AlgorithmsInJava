package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringAsRepeatedSubstringsTests {


    @Test
    public void test() {
        assertTrue(StringAsRepeatedSubstrings.checkString("abababcd", 2));
    }


}