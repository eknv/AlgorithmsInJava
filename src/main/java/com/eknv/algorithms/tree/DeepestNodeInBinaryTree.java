package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;
import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given the root of a binary tree.
 * Return the deepest node (the furthest node from the root).
 */
public class DeepestNodeInBinaryTree {

    private DeepestNodeInBinaryTree() {
    }

    public static TreeNodeWithDepth calculate(TreeNode root) {

        Assert.notNull(root, "root");

        TreeNodeWithDepth deepestTreeNode = null;

        Queue<TreeNodeWithDepth> nodesToProcess = new ArrayDeque<>();
        nodesToProcess.add(new TreeNodeWithDepth(0, root));

        while (!nodesToProcess.isEmpty()) {

            TreeNodeWithDepth next = nodesToProcess.poll();

            if (deepestTreeNode == null || deepestTreeNode.getDepth() < next.getDepth()) {
                deepestTreeNode = next;
            }

            if (next.getNode().getLeftChild() != null) {
                nodesToProcess.add(new TreeNodeWithDepth(next.getDepth() + 1, next.getNode().getLeftChild()));
            }

            if (next.getNode().getRightChild() != null) {
                nodesToProcess.add(new TreeNodeWithDepth(next.getDepth() + 1, next.getNode().getRightChild()));
            }

        }

        return deepestTreeNode;
    }


    static class TreeNodeWithDepth {
        private int depth;
        private TreeNode node;

        public TreeNodeWithDepth(int depth, TreeNode node) {
            Assert.notNull(depth, "depth");
            Assert.notNull(node, "node");
            this.depth = depth;
            this.node = node;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }
    }
}
