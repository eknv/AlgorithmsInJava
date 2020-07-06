package com.eknv.algorithms.dynamic;


import com.eknv.algorithms.tree.model.TreeNode;

/**
 * You are given a binary tree representation of an arithmetic expression.
 * In this tree, each leaf is an integer value,, and a non-leaf node is one of the four operations: '+', '-', '*', or '/'.
 * <p>
 * Write a function that takes this tree and evaluates the expression.
 * <p>
 * Example:
 * <p>
 * *
 * / \
 * +    +
 * / \  / \
 * 3  2  4  5
 * <p>
 * This is a representation of the expression (3 + 2) * (4 + 5), and should return 45.
 */
public class ArithmeticBinaryTree {

    private ArithmeticBinaryTree() {
    }


    public static int calculate(TreeNode<String> node) {
        return getValue(node);
    }

    private static int performOperation(String operation, TreeNode<String> left, TreeNode<String> right) {

        if (operation == null || left == null || right == null) {
            throw new IllegalArgumentException("Both left and right leaves need to be provided");
        }

        switch (operation) {
            case "+":
                return getValue(left) + getValue(right);
            case "-":
                return getValue(left) - getValue(right);
            case "*":
                return getValue(left) * getValue(right);
            case "/":
                return getValue(left) / getValue(right);
            default:
                throw new IllegalArgumentException("The operation " + operation + " is not supported");
        }
    }


    private static int getValue(TreeNode<String> node) {

        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return Integer.valueOf(node.getData());
        } else {
            return performOperation(node.getData(), node.getLeftChild(), node.getRightChild());
        }
    }

}
