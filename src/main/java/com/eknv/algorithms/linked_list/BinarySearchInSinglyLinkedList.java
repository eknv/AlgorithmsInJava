package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;

public class BinarySearchInSinglyLinkedList {

    private BinarySearchInSinglyLinkedList() {
    }

    public static <T extends Comparable<T>> Node<T> execute(
            SinglyLinkedList<T> list, T data) {

        if (list.getHead() == null) {
            return null;
        }

        Node start = list.getHead();
        Node end = null;

        while (start != end || end == null) {
            Node<T> middle = findMiddle(start, end);

            if (middle == null) {
                return null;
            }

            if (middle.getData().equals(data)) {
                return middle;
            } else if (middle.getData().compareTo(data) < 0) {
                start = middle.getNext();
            } else {
                end = middle;
            }
        }

        return null;
    }

    private static <T> Node<T> findMiddle(Node<T> start, Node<T> end) {

        if (start == null) {
            return null;
        }

        if (end == null) {
            return start;
        }

        Node slow = start;
        Node fast = start;

        while (fast != end) {
            fast = fast.getNext();
            if (fast != end) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        return slow;
    }


}
