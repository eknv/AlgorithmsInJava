package com.eknv.algorithms.trie;


import com.eknv.algorithms.trie.model.Trie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoCompleteTests {

    @Test
    void test1() {

        Trie autoCompleteTrie = new Trie(
                "amazon", "amazon prime", "amazing", "amazing spider man",
                "amazed", "alibaba", "ali express", "ebay", "walmart");

        assertEquals("[amazed, amazing, amazing spider man, amazon, amazon prime]",
                AutoComplete.calculate(autoCompleteTrie, "amaz").toString());

    }

}
