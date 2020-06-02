package com.eknv.algorithms.sort_search.search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SparseSearchTests {

    @Test
    void test1() {
        Assertions.assertEquals(1,
                SparseSearch.sparseSearch(new String[]{"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"},
                        "geeks"));
    }

}
