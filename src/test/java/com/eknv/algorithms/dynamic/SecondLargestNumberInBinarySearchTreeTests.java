package com.eknv.algorithms.dynamic;

import com.eknv.algorithms.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Write a method to find the 2nd largest element in a binary search tree.
 */
public class SecondLargestNumberInBinarySearchTreeTests {

    @Test
    public void findSecondLargestTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final TreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        assertEquals(new TreeNode(70), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void largestHasLeftChildTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70).insertLeft(60);
        assertEquals(new TreeNode(60), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void largestHasLeftSubtreeTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final TreeNode b = root.insertRight(70).insertLeft(60);
        b.insertLeft(55).insertRight(58);
        b.insertRight(65);
        assertEquals(new TreeNode(65), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void secondLargestIsRootNodeTest() {
        final TreeNode root = new TreeNode(50);
        final TreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70);
        assertEquals(new TreeNode(50), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }


    @Test
    public void descendingLinkedListTest() {
        final TreeNode root = new TreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20);
        assertEquals(new TreeNode(40), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void ascendingLinkedListTest() {
        final TreeNode root = new TreeNode(50);
        root.insertRight(60).insertRight(70).insertRight(80);
        assertEquals(new TreeNode(70), SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void linkedListWithHeadTest() {
        final TreeNode root = new TreeNode(50);
        assertEquals(null, SecondLargestNumberInBinarySearchTree.findSecondLargest(root));
    }

    @Test
    public void exceptionWithEmptyTreeTest() {
        assertThrows(Exception.class, () -> SecondLargestNumberInBinarySearchTree.findSecondLargest(null));
    }

}