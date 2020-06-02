package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindKthMaxInBST {


    private FindKthMaxInBST() {
    }

    public static <T extends Comparable<T>> TreeNode<T> execute(TreeNode<T> root, int k) {

        if (root == null || k < 0) {
            return null;
        }

        List<TreeNode<T>> sortedElements = new ArrayList<>();

        traverseInOrder(root, sortedElements);

        if (sortedElements.size() > k) {
            return sortedElements.get(sortedElements.size() - k - 1);
        }

        return null;
    }


    private static <T extends Comparable<T>> void traverseInOrder(TreeNode<T> root, List<TreeNode<T>> maxFirstList) {

        if (root.getLeftChild() != null) {
            traverseInOrder(root.getLeftChild(), maxFirstList);
        }

        maxFirstList.add(root);

        if (root.getRightChild() != null) {
            traverseInOrder(root.getRightChild(), maxFirstList);
        }

    }


}
