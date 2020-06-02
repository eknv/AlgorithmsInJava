package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionIntersectionOfListsTests {

    private static Logger logger = LoggerFactory.getLogger(UnionIntersectionOfListsTests.class);
    private SinglyLinkedList<Integer> list1;
    private SinglyLinkedList<Integer> list2;

    @BeforeEach
    void setup() {
        list1 = new SinglyLinkedList<>();
        list2 = new SinglyLinkedList<>();

        for (int i = 0; i <= 4; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list1, i);
        }
        InsertionInSinglyLinkedList.insertAtEnd(list1, 11);
        InsertionInSinglyLinkedList.insertAtEnd(list1, 12);

        for (int i = 5; i <= 10; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list2, i);
        }
        InsertionInSinglyLinkedList.insertAtEnd(list2, 11);
        InsertionInSinglyLinkedList.insertAtEnd(list2, 12);

    }

    @Test
    public void testUnion() {
        logger.debug(String.format("%s | %s", printList(list1.getHead()), printList(list2.getHead())));
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 11 -> 12 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null",
                printList(UnionIntersectionOfLists.union(list1, list2)));
    }

    @Test
    public void testIntersection() {
        logger.debug(String.format("%s | %s", printList(list1.getHead()), printList(list2.getHead())));
        assertEquals("11 -> 12 -> null", printList(UnionIntersectionOfLists.intersection(list1, list2)));
    }


}