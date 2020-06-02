package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EuclideanTests {

    @Test
    public void test1() {

        assertEquals(5, Euclidean.gcd(10, 15));
        assertEquals(5, Euclidean.gcd(35, 10));
        assertEquals(1, Euclidean.gcd(31, 2));
    }

}



