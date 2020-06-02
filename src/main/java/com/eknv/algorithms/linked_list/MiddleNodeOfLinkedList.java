package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import org.springframework.util.Assert;

public class MiddleNodeOfLinkedList {

    private MiddleNodeOfLinkedList() {
    }

    public static <T> Node<T> calculate(Node<T> head) {

        if (head == null) {
            return null;
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast.getNext() != null
                && (slow.equals(head) || !fast.equals(slow))) {
            fast = fast.getNext();
            if (fast.getNext() != null && !fast.equals(slow)) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        Assert.isTrue(!fast.equals(slow) || slow.equals(head), "Loop detected");

        return slow;
    }

}
