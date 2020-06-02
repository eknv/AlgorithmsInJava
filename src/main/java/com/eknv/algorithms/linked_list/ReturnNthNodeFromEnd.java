package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;

public class ReturnNthNodeFromEnd {

    private ReturnNthNodeFromEnd() {
    }

    public static <T> Node<T> execute(Node<T> head, int n) {

        if (n < 0 || head == null) {
            return null;
        }

        Node<T> first = head;
        Node<T> second = head;

        for (int i = 0; i < n; i++) {
            first = first.getNext();
            if (first == null) {
                return null;
            }
        }

        while (first.getNext() != null) {
            first = first.getNext();
            second = second.getNext();
        }

        return second;
    }

}
