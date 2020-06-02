package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a method to see if a binary tree is "superbalanced" (a new tree property we just made up).
 * <p>
 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
 */
public class IsBalancedBinaryTree {

    private IsBalancedBinaryTree() {
    }

    public static <T extends Comparable<T>> boolean calculate(TreeNode<T> treeRoot) {

        if (treeRoot == null) {
            return true;
        }

        List<Integer> depths = new ArrayList<>();

        treeRoot.setDepth(0);

        Deque<TreeNode<T>> nodesToBeProcessed = new LinkedList<>();

        nodesToBeProcessed.add(treeRoot);

        while (!nodesToBeProcessed.isEmpty()) {

            TreeNode<T> nextNode = nodesToBeProcessed.remove();

            /**
             * we have reached a leaf, capture the depth and do the necessary checks
             * note that we are just interested in the difference between the depths of the leaves
             */
            if (nextNode.getLeftChild() == null
                    && nextNode.getRightChild() == null
                    && !depths.contains(nextNode.getDepth())) {
                depths.add(nextNode.getDepth());
            }

            if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                return false;
            }

            if (nextNode.getLeftChild() != null) {
                nextNode.getLeftChild().setDepth(nextNode.getDepth() + 1);
                nodesToBeProcessed.add(nextNode.getLeftChild());
            }

            if (nextNode.getRightChild() != null) {
                nextNode.getRightChild().setDepth(nextNode.getDepth() + 1);
                nodesToBeProcessed.add(nextNode.getRightChild());
            }
        }

        return true;

    }

}
