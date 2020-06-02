package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTwoNumbersInArrayTests {


    @Test
    public void test() {
        assertEquals("[6, 5]",
                FindTwoNumbersInArray.execute(new int[]{1, 3, 5, 6, 23, 133}, 11).toString());
    }

}