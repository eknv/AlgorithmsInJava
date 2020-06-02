package com.eknv.algorithms.trie;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortArrayElementsUsingTrieTests {


    @Test
    void test1() {

        assertEquals("[apple, book, cinema, email, jump]",
                SortArrayElementsUsingTrie.execute(new String[]{"email", "cinema", "jump", "book", "apple"}).toString());

    }

}
