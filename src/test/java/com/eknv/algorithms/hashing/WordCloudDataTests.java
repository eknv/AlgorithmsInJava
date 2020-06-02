package com.eknv.algorithms.hashing;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCloudDataTests {

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("i", 1);
                put("like", 1);
                put("cake", 1);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }


    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("and", 1);
                put("pound", 1);
                put("for", 2);
                put("dessert", 1);
                put("chocolate", 1);
                put("dinner", 1);
                put("cake", 2);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }


    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("cake", 1);
                put("strawberry", 1);
                put("short", 1);
                put("yum", 1);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }


    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("cake", 1);
                put("dessert", 1);
                put("mille-feuille", 1);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }


    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("mmm", 2);
                put("decisions", 2);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<>() {
            {
                put("bakery", 1);
                put("cakes", 1);
                put("allie's", 1);
                put("sasha's", 1);
            }
        };
        assertEquals(expected, WordCloudData.getWordsToCounts(text));
    }

}