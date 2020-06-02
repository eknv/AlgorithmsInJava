package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;

/**
 * Hooray! It's opposite day. Linked lists go the opposite way today.
 * <p>
 * Write a method for reversing a linked list. ↴ Do it in place. ↴
 * <p>
 * Your method will have one input: the head of the list.
 * <p>
 * Your method should return the new head of the list.
 * <p>
 * Here's a sample linked list node class:
 * <p>
 * public class LinkedListNode {
 * <p>
 * public int value;
 * public LinkedListNode next;
 * <p>
 * public LinkedListNode(int value) {
 * this.value = value;
 * }
 * }
 * <p>
 */
public class ReverseLinkedList {

    private ReverseLinkedList() {
    }

    public static Node execute(Node head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {

            /**
             * keep track of next
             */
            next = current.getNext();

            /**
             * update current
             */
            current.setNext(prev);

            /**
             * update prev and current
             */
            prev = current;
            current = next;
        }


        return prev;
    }


}