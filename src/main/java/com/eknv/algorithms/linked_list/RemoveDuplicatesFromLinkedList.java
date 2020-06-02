package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromLinkedList {

    private RemoveDuplicatesFromLinkedList() {
    }

    public static <T> Node<T> execute(SinglyLinkedList<T> list) {

        Node current = list.getHead();

        while (current != null && current.getNext() != null) {

            Node compare = current;

            while (compare.getNext() != null) {

                if (current.getData().equals(compare.getNext().getData())) {
                    Node next = compare.getNext().getNext();
                    compare.getNext().setNext(null);
                    compare.setNext(next);
                } else {
                    compare = compare.getNext();
                }
            }

            current = current.getNext();
        }

        return list.getHead();
    }


    public static <T> Node<T> executeWithHashing(SinglyLinkedList<T> list) {

        if (list.isEmpty()) {
            return null;
        }

        /**
         * record the already encountered nodes
         */
        Set<T> visitedNodes = new HashSet<>();

        /**
         * start with head
         */
        Node<T> current = list.getHead();
        visitedNodes.add(current.getData());

        while (current.getNext() != null) {
            if (visitedNodes.contains(current.getNext().getData())) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
                visitedNodes.add(current.getData());
            }
        }

        return list.getHead();
    }

}