package com.eknv.algorithms.stack_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BracketValidatorTests {

    @Test
    public void validShortCodeTest() {
        final boolean result = BracketValidator.calculate("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = BracketValidator.calculate("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = BracketValidator.calculate("([][]}");
        assertFalse(result);
    }

    @Test
    public void interleavedOpenersAndClosersTest() {
        final boolean result = BracketValidator.calculate("([)]");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = BracketValidator.calculate("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = BracketValidator.calculate("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = BracketValidator.calculate("");
        assertTrue(result);
    }

}