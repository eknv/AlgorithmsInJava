package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DutchNationalFlagSortTests {


    @Test
    void test1() {

        assertEquals("[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2]",
                Arrays.toString(DutchNationalFlagSort.execute(new int[]{1, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
    }


    @Test
    void test2() {

        assertEquals("[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2]",
                Arrays.toString(DutchNationalFlagSort2.execute(new int[]{1, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
    }

}
