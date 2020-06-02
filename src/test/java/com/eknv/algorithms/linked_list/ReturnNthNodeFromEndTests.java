package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnNthNodeFromEndTests {

    private static Logger logger = LoggerFactory.getLogger(ReturnNthNodeFromEndTests.class);
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new SinglyLinkedList<>();

        for (int i = 0; i <= 9; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }

        logger.debug(printList(list.getHead()));
    }


    @Test
    public void detectLoop() {

        assertEquals(null, ReturnNthNodeFromEnd.execute(list.getHead(), 12));

    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void detectLoop(int number) {

        assertEquals(9 - number, ReturnNthNodeFromEnd.execute(list.getHead(), number).getData());

    }


}