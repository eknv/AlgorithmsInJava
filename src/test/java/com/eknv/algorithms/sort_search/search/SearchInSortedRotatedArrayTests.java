package com.eknv.algorithms.sort_search.search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInSortedRotatedArrayTests {


    @Test
    void test1() {
        Assertions.assertEquals(5, SearchInSortedRotatedArray.execute(new int[]{40, 100, -100, 0, 24, 40}, 40));
    }

}
