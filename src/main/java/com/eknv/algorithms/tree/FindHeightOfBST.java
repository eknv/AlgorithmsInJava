package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;

public class FindHeightOfBST {

    private FindHeightOfBST() {
    }

    public static int execute(TreeNode node) {

        if (node == null) {
            return -1;
        }

        return 1 + Math.max(execute(node.getLeftChild()), execute(node.getRightChild()));
    }


}
