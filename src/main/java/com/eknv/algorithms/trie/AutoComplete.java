package com.eknv.algorithms.trie;

import com.eknv.algorithms.trie.model.Trie;
import com.eknv.algorithms.trie.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given a trie with a set of strings stored in it.
 * Now the user types in a prefix of his search query,
 * we need to give him all recommendations to auto-complete his query based on the strings stored in the trie.
 * We assume that the trie stores past searches by the users.
 * <p>
 * For example if the trie store {“abc”, “abcd”, “aa”, “abbbaba”} and the User types in “ab” then he must be shown {“abc”, “abcd”, “abbbaba”}.
 * <p>
 */
public class AutoComplete {

    private AutoComplete() {
    }

    public static List<String> calculate(Trie trie, String prefix) {

        TrieNode currentNode = trie.getRoot();

        for (char c : prefix.toCharArray()) {
            currentNode = currentNode.getChild(c);
            /**
             * if it cannot find a node for this character
             * then return empty list
             */
            if (currentNode == null) {
                return new ArrayList<>();
            }
        }

        /**
         * if we could find an node up to the last character of the prefix
         * then return all the words below that node
         */
        return currentNode.getWords();
    }

}
