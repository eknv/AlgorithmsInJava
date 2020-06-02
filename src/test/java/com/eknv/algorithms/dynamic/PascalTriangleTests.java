package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PascalTriangleTests {


    @Test
    public void test1() {

        assertEquals("[1, 1]", Arrays.toString(PascalTriangle.calculate(1)));
        assertEquals("[1, 2, 1]", Arrays.toString(PascalTriangle.calculate(2)));
        assertEquals("[1, 7, 21, 35, 35, 21, 7, 1]", Arrays.toString(PascalTriangle.calculate(7)));

    }

}