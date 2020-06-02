package com.eknv.algorithms.sort_search.search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInSortedMatrixTests {


    @Test
    void test1() {

        int[][] mat = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
                {35, 36, 42, 55}};

        Assertions.assertEquals("[X=1,Y=1]", SearchInSortedMatrix.execute(mat, 25).toString());
        Assertions.assertEquals(null, SearchInSortedMatrix.execute(mat, 56));
    }


}
