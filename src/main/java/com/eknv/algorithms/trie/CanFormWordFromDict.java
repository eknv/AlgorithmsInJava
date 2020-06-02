package com.eknv.algorithms.trie;

import com.eknv.algorithms.trie.model.Trie;
import com.eknv.algorithms.trie.model.TrieNode;

/**
 * Given are a dictionary and a word
 * Use a trie to find if the given word can be formed
 * by combining two existing words in the dictionary
 */
public class CanFormWordFromDict {

    private CanFormWordFromDict() {
    }

    public static boolean isPossible(String[] dict, String word) {

        int numberOfWords = 0;

        Trie trie = new Trie(dict);
        TrieNode root = trie.getRoot();
        for (char c : word.toCharArray()) {
            TrieNode child = root.getChild(c);
            if (child == null) {
                return false;
            } else {
                if (child.isEnd()) {
                    numberOfWords++;
                    root = trie.getRoot();
                } else {
                    root = child;
                }
            }
        }

        return numberOfWords == 2;
    }

}
