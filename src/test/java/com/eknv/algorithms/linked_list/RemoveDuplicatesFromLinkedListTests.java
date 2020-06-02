package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromLinkedListTests {


    @Test
    public void test1() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 9; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }
        InsertionInSinglyLinkedList.insertAtEnd(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null",
                printList(RemoveDuplicatesFromLinkedList.execute(list)));
    }


    @Test
    public void testWithHashing() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 9; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }
        InsertionInSinglyLinkedList.insertAtEnd(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null",
                printList(RemoveDuplicatesFromLinkedList.executeWithHashing(list)));
    }

}