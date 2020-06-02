package com.eknv.algorithms.sort_search;

import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.sort_search.FindRotationPoint.findRotationPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindRotationPointTests {


    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[]{"cape", "cake"});
        final int expected = 1;
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[]{"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[]{"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        System.out.println(actual);
        assertEquals(expected, actual);
    }

}