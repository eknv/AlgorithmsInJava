package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;

public class LengthOfLinkedList {


    private LengthOfLinkedList() {
    }

    public static int calculate(Node head) {

        int size = 0;
        while (head != null) {
            size++;
            head = head.getNext();
        }

        return size;
    }


}
