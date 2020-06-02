package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;
import org.springframework.util.Assert;

/**
 * Write a method to find the 2nd largest element in a binary search tree.
 */
public class SecondLargestNumberInBinarySearchTree {

    private SecondLargestNumberInBinarySearchTree() {
    }


    public static <T extends Comparable<T>> TreeNode<T> findSecondLargest(TreeNode<T> rootNode) {

        Assert.notNull(rootNode, "rootNode");

        TreeNode<T> current = rootNode;
        TreeNode<T> prev = null;
        while (current.getRightChild() != null) {
            prev = current;
            current = current.getRightChild();
        }

        if (current.getLeftChild() != null) {
            prev = current.getLeftChild();
            while (prev.getRightChild() != null) {
                prev = prev.getRightChild();
            }
        }

        return prev;
    }

}