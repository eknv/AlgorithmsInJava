package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;


public class DeleteDuplicatesInSinglyLinkedList {

    private DeleteDuplicatesInSinglyLinkedList() {
    }

    public static <T> SinglyLinkedList<T> execute(SinglyLinkedList<T> linkedList) {

        Assert.notNull(linkedList, "linkedList");

        if (linkedList.isEmpty()) {
            return linkedList;
        }

        Node<T> current = linkedList.getHead();
        Node<T> prevNode = linkedList.getHead();

        /**
         * keep track of all already visited nodes
         */
        Set<T> visitedNodes = new HashSet<>();

        if (current.getNext() != null) {
            while (current != null) {
                /**
                 * if already visited, delete it
                 */
                if (visitedNodes.contains(current.getData())) {
                    prevNode.setNext(current.getNext());
                    current = current.getNext();
                } else {
                    /**
                     * if not already visited, add it to the list of already visited ones
                     */
                    visitedNodes.add(current.getData());
                    /**
                     * moving on to next element in the list
                     */
                    prevNode = current;
                    current = current.getNext();
                }
            }
        }

        return linkedList;
    }

}
