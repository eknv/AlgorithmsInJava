package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountElementOccurrencesTests {


    @Test
    void test1() {

        assertEquals(4, CountElementOccurances.execute(new int[]{1, 2, 2, 3, 3, 3, 3}, 3));

    }

}
