package com.eknv.algorithms.sort_search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsSorterTests {


    @Test
    void test1() {

        assertEquals("[act, cat, tac, dog, god]",
                AnagramsSorter.execute(new String[]{"cat", "dog", "tac", "god", "act"}).toString());

        assertEquals("[act, cat, tac, book, dog, god]",
                AnagramsSorter.execute(new String[]{"cat", "dog", "tac", "god", "act", "book"}).toString());

    }


    @Test
    void test2() {

        assertEquals("[[cat, tac, act], [dog, god]]",
                AnagramsSorter2.execute(new String[]{"cat", "dog", "tac", "god", "act"}).toString());

        assertEquals("[[cat, tac, act], [dog, god], [book]]",
                AnagramsSorter2.execute(new String[]{"cat", "dog", "tac", "god", "act", "book"}).toString());

    }

}
