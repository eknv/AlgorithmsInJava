package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedList {

    private MergeKSortedLinkedList() {
    }

    public static <T> Node execute(Node<T>... lists) {

        Queue<T> minHeap = new PriorityQueue<>();

        /**
         * put all the values in the priority queue to keep them sorted
         */
        for (Node<T> head : lists) {
            while (head != null) {
                minHeap.add(head.getData());
                head = head.getNext();
            }
        }

        /**
         * Create a new linked list
         */
        Node dummy = new Node(-1);

        /**
         * keep a reference to the head node
         */
        Node head = dummy;

        /**
         * take the values one by one out of the sorted queue and put them in the linked list
         */
        while (!minHeap.isEmpty()) {
            head.setNext(new Node(minHeap.remove()));
            head = head.getNext();
        }

        /**
         * return the node after the head (head was just a dummy)
         */
        return dummy.getNext();
    }


}
