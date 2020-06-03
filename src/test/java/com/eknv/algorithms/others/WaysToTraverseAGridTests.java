package com.eknv.algorithms.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WaysToTraverseAGridTests {


    @Test
    public void test() {

        assertEquals(2, WaysToTraverseAGrid.calculate(2, 2));
        assertEquals(3, WaysToTraverseAGrid.calculate(3, 2));
        assertEquals(6, WaysToTraverseAGrid.calculate(3, 3));

    }

}