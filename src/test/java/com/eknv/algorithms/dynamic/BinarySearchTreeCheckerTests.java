package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.dynamic.BinarySearchTreeChecker.calculate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeCheckerTests {


    @Test
    public void validFullTreeTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final TreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        assertTrue(calculate(root));
    }

    @Test
    public void bothSubtreesValidTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final TreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        assertFalse(calculate(root));
    }

    @Test
    public void descendingLinkedListTest() {
        final TreeNode root = new TreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        assertTrue(calculate(root));
    }

    @Test
    public void outOfOrderLinkedListTest() {
        final TreeNode root = new TreeNode(50);
        root.insertRight(70).insertRight(60).insertRight(80);
        assertFalse(calculate(root));
    }

    @Test
    public void oneNodeTreeTest() {
        final TreeNode root = new TreeNode(50);
        assertTrue(calculate(root));
    }


}