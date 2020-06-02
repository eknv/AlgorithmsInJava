package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MakingChangeTests {


    @Test
    public void sampleInputTest() {
        final int actual = MakingChange.changePossibilities(4, new int[]{1, 2, 3});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void oneWayToMakeZeroCentsTest() {
        final int actual = MakingChange.changePossibilities(0, new int[]{1, 2});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void noWaysIfNoCoinsTest() {
        final int actual = MakingChange.changePossibilities(1, new int[]{});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigCoinValueTest() {
        final int actual = MakingChange.changePossibilities(5, new int[]{25, 50});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigTargetAmountTest() {
        final int actual = MakingChange.changePossibilities(50, new int[]{5, 10});
        final int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void changeForOneDollarTest() {
        final int actual = MakingChange.changePossibilities(100, new int[]{1, 5, 10, 25, 50});
        final int expected = 292;
        assertEquals(expected, actual);
    }

}