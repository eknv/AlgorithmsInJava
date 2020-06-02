package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLinkedListTests {

    private static Logger logger = LoggerFactory.getLogger(LengthOfLinkedListTests.class);
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
    public void test() {
        assertEquals(11, LengthOfLinkedList.calculate(list.getHead()));
        assertEquals(0, LengthOfLinkedList.calculate(null));
    }


}