package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;

public class DetectLoopInLinkedList {

    private DetectLoopInLinkedList() {
    }

    public static <T> boolean execute(Node<T> head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null && !fast.equals(slow)) {
            fast = fast.getNext();
            if (fast != null && fast.getNext() != null && !fast.equals(slow)) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        return fast != null && fast.equals(slow);
    }

}
