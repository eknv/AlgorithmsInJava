package com.eknv.algorithms.trie;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanFormWordFromDictTests {


    @Test
    void test1() {

        assertEquals(true, CanFormWordFromDict.isPossible(new String[]{"note", "book"}, "notebook"));
        assertEquals(false, CanFormWordFromDict.isPossible(new String[]{"note", "book"}, "bookshop"));

    }

}
