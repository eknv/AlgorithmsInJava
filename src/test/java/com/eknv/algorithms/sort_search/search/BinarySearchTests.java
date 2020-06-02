package com.eknv.algorithms.sort_search.search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {


    @Test
    void test1() {

        int[] arr = {-100, 0, 0, 1, 4, 4, 5, 5, 95, 200};

        Assertions.assertEquals(-1, BinarySearch.execute(arr, 201));
        Assertions.assertEquals(arr.length - 1, BinarySearch.execute(arr, 200));
        Assertions.assertEquals(4, BinarySearch.execute(arr, 4));
    }


}
