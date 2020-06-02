package com.eknv.algorithms.trie;

import com.eknv.algorithms.trie.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllWords {

    private FindAllWords() {
    }

    public static List<String> calculate(TrieNode root) {

        List<String> words = new ArrayList<>();

        if (root.isEnd()) {
            String rootString = root.toString();
            if (rootString != null && !rootString.isEmpty()) {
                words.add(rootString);
            }
        }

        for (TrieNode child : root.getChildren()) {
            if (child != null) {
                words.addAll(calculate(child));
            }
        }

        return words;
    }


}
