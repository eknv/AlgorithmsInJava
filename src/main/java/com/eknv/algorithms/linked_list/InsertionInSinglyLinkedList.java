package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;

public class InsertionInSinglyLinkedList {

    private InsertionInSinglyLinkedList() {
    }

    public static <T> SinglyLinkedList<T> insertAtHead(SinglyLinkedList<T> linkedList, T data) {
        Node<T> node = new Node(data);
        node.setNext(linkedList.getHead());
        linkedList.setHead(node);
        linkedList.setSize(linkedList.getSize() + 1);
        return linkedList;
    }

    public static <T> SinglyLinkedList<T> insertAtEnd(SinglyLinkedList<T> linkedList, T data) {
        Node node = new Node(data);

        if (linkedList.getHead() == null) {
            linkedList.setHead(node);
        } else {
            Node lastElement = linkedList.getHead();
            while (lastElement.getNext() != null) {
                lastElement = lastElement.getNext();
            }
            lastElement.setNext(node);
        }

        linkedList.setSize(linkedList.getSize() + 1);

        return linkedList;
    }

}
