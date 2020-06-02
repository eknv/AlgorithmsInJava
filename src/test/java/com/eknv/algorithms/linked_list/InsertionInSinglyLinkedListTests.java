package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionInSinglyLinkedListTests {

    private static Logger logger = LoggerFactory.getLogger(InsertionInSinglyLinkedListTests.class);
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new SinglyLinkedList<>();
        for (int i = 0; i < 9; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }
        InsertionInSinglyLinkedList.insertAtEnd(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        logger.debug(printList(list.getHead()));
    }

    @Test
    public void insertAtHead() {
        assertEquals("123 -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 0 -> 1 -> null",
                printList(InsertionInSinglyLinkedList.insertAtHead(list, 123)));
        assertEquals("123 -> null",
                printList(InsertionInSinglyLinkedList.insertAtHead(new SinglyLinkedList<>(), 123)));
    }

    @Test
    public void insertAtEnd() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 0 -> 1 -> 123 -> null",
                printList(InsertionInSinglyLinkedList.insertAtEnd(list, 123)));
        assertEquals("123 -> null",
                printList(InsertionInSinglyLinkedList.insertAtEnd(new SinglyLinkedList<>(), 123)));
    }

}