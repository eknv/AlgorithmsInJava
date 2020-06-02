package com.eknv.algorithms.trie;

import com.eknv.algorithms.trie.model.Trie;
import com.eknv.algorithms.trie.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class SortArrayElementsUsingTrie {

    private SortArrayElementsUsingTrie() {
    }

    public static List<String> execute(String[] arr) {

        /**
         * this trie implementation keeps the node children in a sorted array
         */
        Trie dictionary = new Trie(arr);

        return words(dictionary.getRoot());
    }

    private static List<String> words(TrieNode node) {

        List<String> words = new ArrayList<>();

        if (node.isEnd()) {
            words.add(node.toString());
        }

        for (TrieNode child : node.getChildren()) {
            if (child != null) {
                words.addAll(words(child));
            }
        }

        return words;
    }


}
