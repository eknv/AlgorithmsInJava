package com.eknv.algorithms.trie.model;

import java.util.Arrays;


public class Trie {


    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public Trie(String... terms) {
        this();
        if (terms != null) {
            Arrays.stream(terms).forEach(this::insert);
        }
    }

    public void insert(String word) {

        if (exists(word)) {
            return;
        }

        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode parent = current;
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
            } else {
                current.setChild(ch);
                current = current.getChild(ch);
                current.setParent(parent);
            }
        }

        current.setEnd(true);
    }

    public boolean exists(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode childForChar = current.getChild(ch);
            if (childForChar == null) {
                return false;
            } else {
                current = childForChar;
            }
        }
        return current.isEnd();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }
}
