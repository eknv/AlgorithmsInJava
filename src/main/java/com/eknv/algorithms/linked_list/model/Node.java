package com.eknv.algorithms.linked_list.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Node<T> implements Comparable<Node<T>> {

    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node<T> node) {
        this.data = node.getData();
        this.next = node.getNext();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> setNext(Node next) {
        this.next = next;
        return this.next;
    }

    public Node<T> next(T data) {
        this.next = new Node(data);
        return this.next;
    }

    @Override
    public int compareTo(Node<T> o) {
        return new CompareToBuilder()
                .append(this.getData(), o.getData())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getData()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        return new EqualsBuilder().append(this.getData(), ((Node) obj).getData()).isEquals();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getData());
        Node<T> curentNode = this;
        while (curentNode.getNext() != null) {
            sb.append(" -> ");
            curentNode = curentNode.getNext();
            sb.append(curentNode.getData());
        }

        sb.append(" -> null");

        return sb.toString();
    }
}
