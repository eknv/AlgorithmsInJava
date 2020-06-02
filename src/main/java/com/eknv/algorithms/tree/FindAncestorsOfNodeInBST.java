package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAncestorsOfNodeInBST {

    private FindAncestorsOfNodeInBST() {
    }

    public static <T extends Comparable<T>> List<TreeNode<T>> execute(TreeNode<T> root, T value) {

        if (root == null || value == null) {
            return new ArrayList<>();
        }

        List<TreeNode<T>> ancestors = new ArrayList<>();

        while (!value.equals(root.getData())) {

            ancestors.add(root);

            if (value.compareTo(root.getData()) > 0) {
                /**
                 * if we cannot find the value
                 */
                if (root.getRightChild() == null) {
                    return new ArrayList<>();
                } else {
                    root = root.getRightChild();
                }
            } else {
                /**
                 * if we cannot find the value
                 */
                if (root.getLeftChild() == null) {
                    return new ArrayList<>();
                } else {
                    root = root.getLeftChild();
                }
            }

        }

        return ancestors;
    }


}
