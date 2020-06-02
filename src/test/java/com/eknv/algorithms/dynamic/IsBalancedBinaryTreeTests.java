package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IsBalancedBinaryTreeTests {


    @Test
    public void fullTreeTest() {
        final TreeNode root = new TreeNode(5);
        final TreeNode a = root.insertLeft(8);
        final TreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        assertTrue(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final TreeNode root = new TreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        assertTrue(IsBalancedBinaryTree.calculate(root));
    }


    @Test
    public void leafHeightsDifferByOneTest() {
        final TreeNode root = new TreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7);
        assertTrue(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final TreeNode root = new TreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        assertFalse(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final TreeNode root = new TreeNode(1);
        root.insertLeft(5);
        final TreeNode b = root.insertRight(9);
        b.insertLeft(8).insertLeft(7);
        b.insertRight(5);
        assertFalse(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void bothSubTreesSuperbalancedTwoTest() {
        final TreeNode root = new TreeNode(1);
        final TreeNode a = root.insertLeft(2);
        a.insertLeft(3);
        a.insertRight(7).insertRight(8);
        root.insertRight(4).insertRight(5).insertRight(6).insertRight(9);
        assertFalse(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void threeLeavesAtDifferentLevelsTest() {
        final TreeNode root = new TreeNode(1);
        final TreeNode a = root.insertLeft(2);
        final TreeNode b = a.insertLeft(3);
        a.insertRight(4);
        b.insertLeft(5);
        b.insertRight(6);
        root.insertRight(7).insertRight(8).insertRight(9).insertRight(10);
        assertFalse(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void onlyOneNodeTest() {
        final TreeNode root = new TreeNode(1);
        assertTrue(IsBalancedBinaryTree.calculate(root));
    }

    @Test
    public void treeIsLinkedListTest() {
        final TreeNode root = new TreeNode(1);
        root.insertRight(2).insertRight(3).insertRight(4);
        assertTrue(IsBalancedBinaryTree.calculate(root));
    }


}
