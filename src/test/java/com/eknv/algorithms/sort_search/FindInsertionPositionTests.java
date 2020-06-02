package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindInsertionPositionTests {

    @Test
    void test1() {

        assertEquals(1,
                FindInsertionPosition.execute(new int[]{1, 3, 5, 6, 23, 133, 606, 1111, 2222}, 2));
    }

}
