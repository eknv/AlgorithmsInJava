package com.eknv.algorithms.trie.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class TrieNode implements Comparable<TrieNode> {

    private char data;
    private boolean isEnd;

    private TrieNode parent;
    /**
     * children are kept in an array
     * in order to keep them sorted based on the relative index of the characters
     * to the space character, see {@link #getIndex(char) getIndex}
     * <p/>
     * this implementation requires more space but provides a fast way to keep the children sorted at all times
     */
    private TrieNode[] children;

    public TrieNode(char c) {
        data = c;
        children = new TrieNode[255];
        isEnd = false;
    }

    /**
     * returning the relativ index of the given character to a space character ' '
     */
    private int getIndex(char c) {
        return c - ' ';
    }

    public void setChild(char c) {
        children[getIndex(c)] = new TrieNode(c);
    }

    public TrieNode getChild(char c) {
        return children[getIndex(c)];
    }

    public List<String> getWords() {
        List<String> list = new ArrayList<>();

        if (isEnd) {
            list.add(toString());
        }

        if (this.children != null) {
            for (TrieNode child : children) {
                if (child != null) {
                    list.addAll(child.getWords());
                }
            }
        }

        return list;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    @Override
    public int compareTo(TrieNode o) {
        return new CompareToBuilder().append(this.getData(), o.getData()).toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getData()).build();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TrieNode)) {
            return false;
        }
        return new EqualsBuilder()
                .append(this.getData(), ((TrieNode) obj).getData())
                .build();
    }

    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + data;
        }
    }
}
