package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditDistanceTests {

    @Test
    void test1() {

        assertEquals(3, EditDistance.calculate("sunday", "saturday"));
        assertEquals(4, EditDistance.calculate("food", "money"));

    }

}
