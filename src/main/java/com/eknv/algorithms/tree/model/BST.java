package com.eknv.algorithms.tree.model;

public class BST<T extends Comparable<T>> {

    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public TreeNode recursiveInsert(TreeNode<T> node, T value) {

        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (node == null) {
            return new TreeNode(value);
        }

        if (value.compareTo(node.getData()) <= 0) {
            node.setLeftChild(recursiveInsert(node.getLeftChild(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRightChild(recursiveInsert(node.getRightChild(), value));
        } else {
            return node;
        }

        return node;
    }


    public boolean add(T value) {
        root = recursiveInsert(this.root, value);
        return true;
    }

}