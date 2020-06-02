package com.eknv.algorithms.stack_queue;

import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.stack_queue.ParenthesisMatching.getClosingParen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParenthesisMatchingTests {


    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test
    public void noMatchingCloserTest() {
        assertThrows(Exception.class, () -> getClosingParen("()(()", 2));

    }

}