package com.eknv.algorithms.dynamic;


import com.eknv.algorithms.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticBinaryTreeTests {

    @Test
    void testMultiply() {
        TreeNode<String> root = new TreeNode<>("*");
        root.insertRight("2");
        root.insertLeft("5");
        assertEquals(10, ArithmeticBinaryTree.calculate(root));
    }

    @Test
    void testAdd() {
        TreeNode<String> root = new TreeNode<>("+");
        root.insertRight("2");
        root.insertLeft("5");
        assertEquals(7, ArithmeticBinaryTree.calculate(root));
    }

    @Test
    void testMinus() {
        TreeNode<String> root = new TreeNode<>("-");
        root.insertRight("2");
        root.insertLeft("5");
        assertEquals(3, ArithmeticBinaryTree.calculate(root));
    }

    @Test
    void testDivision() {
        TreeNode<String> root = new TreeNode<>("/");
        root.insertRight("2");
        root.insertLeft("5");
        assertEquals(2, ArithmeticBinaryTree.calculate(root));
    }

    @Test
    void testMix() {
        TreeNode<String> root = new TreeNode<>("*");
        TreeNode<String> left = root.insertLeft("+");
        TreeNode<String> right = root.insertRight("+");
        left.insertLeft("3");
        left.insertRight("2");
        right.insertLeft("4");
        right.insertRight("5");
        assertEquals(45, ArithmeticBinaryTree.calculate(root));
    }

    @Test
    void testUnbalanced() {
        TreeNode<String> root = new TreeNode<>("*");
        root.insertRight("2");
        assertThrows(RuntimeException.class, () -> ArithmeticBinaryTree.calculate(root));
    }


}
