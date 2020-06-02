package com.eknv.algorithms.hashing;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsFinderTests {


    @Test
    void test1() {

        assertEquals("[[cat, tac, act], [dog, god]]", AnagramsFinder.execute(new String[]{"cat", "dog", "tac", "god", "act", "sport"}).toString());
    }


}
