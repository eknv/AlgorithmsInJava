package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeepestNodeInBinaryTreeTests {


    @Test
    void test1() {

        TreeNode root = new TreeNode(0);

        assertEquals(0, DeepestNodeInBinaryTree.calculate(root).getDepth());
    }

    @Test
    void test2() {

        TreeNode root = new TreeNode(0);
        root.insertRight(1).insertRight(2).insertRight(3);

        assertEquals(3, DeepestNodeInBinaryTree.calculate(root).getDepth());
    }

    @Test
    void test3() {

        TreeNode root = new TreeNode(0);
        root.insertRight(1).insertRight(2).insertRight(3);
        root.insertLeft(1).insertLeft(2).insertLeft(3);

        assertEquals(3, DeepestNodeInBinaryTree.calculate(root).getDepth());
    }

    @Test
    void test4() {

        TreeNode root = new TreeNode(0);
        root.insertRight(1).insertRight(2).insertRight(3);
        root.insertLeft(1).insertLeft(2).insertLeft(3).insertLeft(4);

        assertEquals(4, DeepestNodeInBinaryTree.calculate(root).getDepth());
    }

    @Test
    void testLeftRight() {

        TreeNode root = new TreeNode(0);
        root.insertRight(1).insertLeft(2).insertRight(3);

        assertEquals(3, DeepestNodeInBinaryTree.calculate(root).getDepth());
    }

    @Test
    void testNullRoot() {

        TreeNode root = new TreeNode(0);
        root.insertRight(1).insertLeft(2).insertRight(3);

        assertThrows(Exception.class, () -> DeepestNodeInBinaryTree.calculate(null));
    }


}
