package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteDuplicatesInSinglyLinkedListTests {

    private static Logger logger = LoggerFactory.getLogger(DeleteDuplicatesInSinglyLinkedListTests.class);
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new SinglyLinkedList<>();
        InsertionInSinglyLinkedList.insertAtEnd(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        InsertionInSinglyLinkedList.insertAtEnd(list, 2);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        InsertionInSinglyLinkedList.insertAtEnd(list, 2);
        InsertionInSinglyLinkedList.insertAtEnd(list, 5);
        logger.debug(printList(list.getHead()));
    }

    @Test
    public void insertAtHead() {
        assertEquals("0 -> 1 -> 2 -> 5 -> null",
                printList(DeleteDuplicatesInSinglyLinkedList.execute(list)));
    }

}