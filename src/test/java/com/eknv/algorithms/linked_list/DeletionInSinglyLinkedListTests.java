package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletionInSinglyLinkedListTests {

    private static Logger logger = LoggerFactory.getLogger(DeletionInSinglyLinkedListTests.class);
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
    public void deleteHead() {
        assertEquals(true, DeletionInSinglyLinkedList.deleteHead(list));
        assertEquals(false, DeletionInSinglyLinkedList.deleteHead(new SinglyLinkedList<>()));
    }

    @Test
    public void deleteTail() {
        assertEquals(true, DeletionInSinglyLinkedList.deleteTail(list));
        assertEquals(false, DeletionInSinglyLinkedList.deleteTail(new SinglyLinkedList<>()));
    }

    @Test
    public void deleteFirstValue() {
        assertEquals(true, DeletionInSinglyLinkedList.deleteFirstWithValue(list, 1));
        assertEquals(true, DeletionInSinglyLinkedList.deleteFirstWithValue(list, 2));
        assertEquals(false, DeletionInSinglyLinkedList.deleteFirstWithValue(new SinglyLinkedList<>(), 0));
    }

    @Test
    public void deleteAllWithValue() {
        assertEquals(2, DeletionInSinglyLinkedList.deleteAllWithValue(list, 0));
        assertEquals(1, DeletionInSinglyLinkedList.deleteAllWithValue(list, 2));
        assertEquals(0, DeletionInSinglyLinkedList.deleteAllWithValue(new SinglyLinkedList<>(), 0));
    }

}