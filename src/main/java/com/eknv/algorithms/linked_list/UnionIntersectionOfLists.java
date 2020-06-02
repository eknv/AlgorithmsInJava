package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;

public class UnionIntersectionOfLists {

    private UnionIntersectionOfLists() {
    }

    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        if (list1.isEmpty()) {
            return list2;
        }

        if (list2.isEmpty()) {
            return list1;
        }

        Node<T> last = list1.getHead();

        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(list2.getHead());

        RemoveDuplicatesFromLinkedList.executeWithHashing(list1);

        return list1;
    }


    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        SinglyLinkedList<T> result = new SinglyLinkedList<>();

        if (list1.isEmpty()) {
            return result;
        }

        if (list2.isEmpty()) {
            return result;
        }

        Node<T> current = list1.getHead();

        while (current != null) {
            if (contains(list2, current.getData())) {
                InsertionInSinglyLinkedList.insertAtEnd(result, current.getData());
            }
            current = current.getNext();
        }

        return result;
    }


    private static <T> boolean contains(SinglyLinkedList<T> list, T data) {
        Node<T> current = list.getHead();
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}

