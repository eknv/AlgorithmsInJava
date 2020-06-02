package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import org.springframework.util.Assert;

/**
 * Given a linked list of integers, remove all consecutive nodes that sum up to 0.
 * <p>
 * Example:
 * <p>
 * Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
 * Output: 10
 * <p>
 * The consecutive nodes 5 -> -3 -> -3 -> 1 sums up to 0 so that sequence should be removed.
 * 4 -> -4 also sums up to 0 too so that sequence should also be removed.
 */

public class RemoveConsecutiveNodesBuildingASum {

    private RemoveConsecutiveNodesBuildingASum() {
    }

    public static Node<Integer> execute(Node<Integer> head) {

        Assert.notNull(head, "head cannot be null");

        int targetValue = 0;

        Node<Integer> dummyHead = new Node<>(-1);
        dummyHead.setNext(head);

        Node<Integer> newHead = dummyHead;
        Node<Integer> currentNode = dummyHead;

        while (newHead != null) {

            int count = 0;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                count += currentNode.getData();
                if (count == targetValue) {
                    newHead.setNext(currentNode.getNext());
                    count = 0;
                }
            }

            newHead = newHead.getNext();
            currentNode = newHead;
        }

        return dummyHead.getNext();

    }

}
