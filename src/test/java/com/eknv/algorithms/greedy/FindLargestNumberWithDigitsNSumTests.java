package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLargestNumberWithDigitsNSumTests {

    @Test
    public void test() {

        assertEquals("1/3 + 1/11 + 1/231",
                EgyptianFraction.printEgyptian(6, 14)
                        .stream().collect(Collectors.joining(" + ")));
    }

}