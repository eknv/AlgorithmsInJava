package com.eknv.algorithms.others;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestCommonSuperstringOfTwoTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        ShortestCommonSuperstringOfTwo shortestCommonSuperstringOfTwo = new ShortestCommonSuperstringOfTwo();

        assertEquals("Cleangular", shortestCommonSuperstringOfTwo.calculate("Clean","angular"));
        assertEquals("angularClean", shortestCommonSuperstringOfTwo.calculate("Clean","angularCle"));
        assertEquals("Cleansite", shortestCommonSuperstringOfTwo.calculate("Clean","site"));
    }

}
