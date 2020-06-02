package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindDuplicatesInArrayTests {

    @Test
    void test1() {

        assertEquals("[5, 12]",
                FindDuplicatesInArray.execute(new int[]{12, 11, 40, 12, 5, 6, 5, 12, 11}).toString());
    }


    @Test
    void test2() {

        assertThrows(Exception.class,
                () -> FindDuplicatesInArray2.execute(new int[]{12, 11, 40, 12, 5, 6, 5, 12, 11}));

        assertEquals("[1, 3, 6]",
                FindDuplicatesInArray2.execute(new int[]{3, 2, 1, 1, 3, 6, 6, 7, 0}).toString());
    }


    @Test
    void test3() {

        assertThrows(Exception.class,
                () -> FindDuplicatesInArray3.execute(new int[]{12, 11, 40, 12, 5, 6, 5, 12, 11}));

        assertEquals("[1, 3, 6]",
                FindDuplicatesInArray3.execute(new int[]{3, 2, 1, 1, 3, 6, 6, 7, 0}).toString());
    }

}
