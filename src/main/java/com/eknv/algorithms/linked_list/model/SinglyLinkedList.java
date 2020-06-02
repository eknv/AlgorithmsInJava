package com.eknv.algorithms.linked_list.model;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public static <U> String printList(SinglyLinkedList<U> singlyLinkedList) {
        if (singlyLinkedList == null) {
            return printList((Node) null);
        } else {
            return printList(singlyLinkedList.getHead());
        }
    }


    public static <U> String printList(Node<U> head) {

        if (head == null) {
            return "List is Empty!";
        }

        StringBuilder sb = new StringBuilder();

        Node<U> temp = head;

        while (temp.getNext() != null) {
            sb.append(temp.getData().toString()).append(" -> ");
            temp = temp.getNext();
        }

        sb.append(temp.getData().toString()).append(" -> null");

        return sb.toString();
    }

}
