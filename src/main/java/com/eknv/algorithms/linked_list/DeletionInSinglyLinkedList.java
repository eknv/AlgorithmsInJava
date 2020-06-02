package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * delete a node by value
 */
public class DeletionInSinglyLinkedList {

    private static Logger logger = LoggerFactory.getLogger(DeletionInSinglyLinkedList.class);

    private DeletionInSinglyLinkedList() {
    }

    public static <T> boolean deleteHead(SinglyLinkedList<T> linkedList) {

        if (linkedList == null || linkedList.isEmpty()) {
            return false;
        }

        Node<T> temp = linkedList.getHead();
        Node<T> head = temp.getNext();

        temp.setNext(null);

        linkedList.setHead(head);
        linkedList.setSize(linkedList.getSize() - 1);

        log(linkedList.getHead());

        return true;
    }

    public static <T> boolean deleteTail(SinglyLinkedList<T> linkedList) {

        if (linkedList == null || linkedList.isEmpty()) {
            return false;
        }

        if (linkedList.getSize() == 1) {
            return deleteHead(linkedList);
        }

        Node<T> current = linkedList.getHead();
        Node<T> prev = current;
        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);

        linkedList.setSize(linkedList.getSize() - 1);

        log(linkedList.getHead());

        return true;
    }

    public static <T> boolean deleteFirstWithValue(SinglyLinkedList<T> linkedList, T data) {

        if (linkedList == null || linkedList.isEmpty()) {
            return false;
        }

        Assert.notNull(data, "data cannot be null");

        Node<T> node = linkedList.getHead();
        if (data.equals(node.getData())) {
            return deleteHead(linkedList);
        }

        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                Node<T> next = node.getNext();
                node.setNext(next.getNext());
                next.setNext(null);
                log(linkedList.getHead());
                return true;
            } else {
                node = node.getNext();
            }
        }

        log(linkedList.getHead());

        return false;
    }

    public static <T> int deleteAllWithValue(SinglyLinkedList<T> linkedList, T data) {

        if (linkedList == null || linkedList.isEmpty()) {
            return 0;
        }

        Assert.notNull(data, "data cannot be null");

        int numberOfDeletedNodes = 0;

        Node<T> node = linkedList.getHead();
        if (data.equals(node.getData())) {
            deleteHead(linkedList);
            node = linkedList.getHead();
            numberOfDeletedNodes++;
        }


        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                Node<T> next = node.getNext();
                node.setNext(next.getNext());
                next.setNext(null);
                numberOfDeletedNodes++;
            } else {
                node = node.getNext();
            }
        }

        log(linkedList.getHead());

        return numberOfDeletedNodes;
    }

    private static <T> void log(Node<T> node) {
        if (logger.isDebugEnabled()) {
            logger.debug(SinglyLinkedList.printList(node));
        }
    }

}
