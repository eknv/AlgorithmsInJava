package com.eknv.algorithms.tree.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private T data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    /**
     * additional metadata
     */
    private int depth;
    private T upperBound;
    private T lowerBound;

    public TreeNode(T value) {
        this.data = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public T getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(T upperBound) {
        this.upperBound = upperBound;
    }

    public T getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(T lowerBound) {
        this.lowerBound = lowerBound;
    }

    public TreeNode insertLeft(int leftValue) {
        this.setLeftChild(new TreeNode(leftValue));
        return this.getLeftChild();
    }

    public TreeNode insertRight(int rightValue) {
        this.setRightChild(new TreeNode(rightValue));
        return this.getRightChild();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getData()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        return new EqualsBuilder()
                .append(this.getData(), ((TreeNode) obj).getData())
                .isEquals();
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return new CompareToBuilder()
                .append(this.getData(), o.getData())
                .toComparison();
    }

    @Override
    public String toString() {
        return this.getData() != null ? this.getData().toString() : "null";
    }
}
