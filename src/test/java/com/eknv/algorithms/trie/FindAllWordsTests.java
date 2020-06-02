package com.eknv.algorithms.trie;


import com.eknv.algorithms.trie.model.Trie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllWordsTests {


    @Test
    void test1() {

        Trie dictionary = new Trie(
                "amazon", "amazon prime", "amazing", "amazing spider man",
                "amazed", "alibaba", "ali express", "ebay", "walmart");

        assertEquals("[ali express, alibaba, amazed, amazing, amazing spider man, amazon, amazon prime, ebay, walmart]",
                FindAllWords.calculate(dictionary.getRoot()).toString());

    }

}
