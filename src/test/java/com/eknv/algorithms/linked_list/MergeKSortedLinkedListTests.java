package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeKSortedLinkedListTests {

    @Test
    public void test1() {

        List<Node> headNodes = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            for (int j = 1; j <= 3; j++) {
                InsertionInSinglyLinkedList.insertAtEnd(list, i + 3 * j);
            }
            headNodes.add(list.getHead());
        }

        assertEquals("4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> null",
                printList(MergeKSortedLinkedList.execute(headNodes.toArray(new Node[headNodes.size()]))));
    }


}