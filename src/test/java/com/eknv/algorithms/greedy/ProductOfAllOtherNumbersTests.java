package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductOfAllOtherNumbersTests {

    @Test
    public void test() {

        assertEquals("[6, 3, 2]",
                Arrays.toString(ProductOfAllOtherNumbers.getProductsOfAllIntsExceptAtIndex(new int[]{1, 2, 3})));
    }


}