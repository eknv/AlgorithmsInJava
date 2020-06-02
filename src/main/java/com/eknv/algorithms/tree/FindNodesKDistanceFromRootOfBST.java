package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindNodesKDistanceFromRootOfBST {


    private FindNodesKDistanceFromRootOfBST() {
    }

    public static <T extends Comparable<T>> List<TreeNode<T>> execute(TreeNode<T> root, int distance) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode<T>> nodesAtLevel = new ArrayList<>();

        traverseNodes(root, distance, nodesAtLevel);

        return nodesAtLevel;
    }

    private static <T extends Comparable<T>> void traverseNodes(TreeNode<T> node, int level, List<TreeNode<T>> nodes) {

        if (node == null || level < 0) {
            return;
        }

        if (level == 0) {
            nodes.add(node);
        } else {
            traverseNodes(node.getLeftChild(), level - 1, nodes);
            traverseNodes(node.getRightChild(), level - 1, nodes);
        }
    }


}
