package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Write a method to check that a binary tree is a valid binary search tree.
 * <p>
 * A binary search tree is a binary tree where the nodes are ordered in a specific way. For every node:
 * <p>
 * - The nodes to the left are smaller than the current node.
 * - The nodes to the right are larger than the current node.
 */
public class BinarySearchTreeChecker {

    private BinarySearchTreeChecker() {
    }

    public static boolean calculate(TreeNode root) {

        if (root == null) {
            return true;
        }

        /**
         * determine if the tree is a valid binary search tree
         */
        Deque<TreeNode> nodesToCheck = new ArrayDeque<>();

        root.setUpperBound(Integer.MAX_VALUE);
        root.setLowerBound(Integer.MIN_VALUE);
        nodesToCheck.add(root);

        while (!nodesToCheck.isEmpty()) {
            TreeNode nextNode = nodesToCheck.pop();

            if (nextNode.getData().compareTo(nextNode.getUpperBound()) > 0
                    || nextNode.getData().compareTo(nextNode.getLowerBound()) <= 0) {
                return false;
            }

            if (nextNode.getLeftChild() != null) {
                nextNode.getLeftChild().setLowerBound(nextNode.getLowerBound());
                nextNode.getLeftChild().setUpperBound(nextNode.getData());
                nodesToCheck.add(nextNode.getLeftChild());
            }

            if (nextNode.getRightChild() != null) {
                nextNode.getRightChild().setLowerBound(nextNode.getData());
                nextNode.getRightChild().setUpperBound(nextNode.getUpperBound());
                nodesToCheck.add(nextNode.getRightChild());
            }
        }

        return true;
    }

}