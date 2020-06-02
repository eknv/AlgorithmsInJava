package com.eknv.algorithms.trie;

import com.eknv.algorithms.trie.model.TrieNode;

/**
 * If you are given a trie, can you find the total number of words it contains?
 */
public class TotalNumberOfWords {

    private TotalNumberOfWords() {
    }

    public static int calculate(TrieNode root) {

        if (root == null) {
            throw new IllegalArgumentException("TrieNode root cannot be null");
        }

        int wordCount = 0;

        if (root.isEnd()) {
            wordCount++;
        }

        for (TrieNode child : root.getChildren()) {
            if (child != null) {
                wordCount += calculate(child);
            }
        }

        return wordCount;
    }

}
