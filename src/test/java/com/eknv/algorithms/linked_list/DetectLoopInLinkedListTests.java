package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.Node;
import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.eknv.algorithms.linked_list.model.SinglyLinkedList.printList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectLoopInLinkedListTests {

    private static Logger logger = LoggerFactory.getLogger(DetectLoopInLinkedListTests.class);
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

        assertEquals(false, DetectLoopInLinkedList.execute(list.getHead()));

        list.getHead().getNext().setNext(list.getHead());
        assertEquals(true, DetectLoopInLinkedList.execute(list.getHead()));

        assertEquals(false, DetectLoopInLinkedList.execute(null));
    }

    @Test
    public void detectLoop2() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        InsertionInSinglyLinkedList.insertAtHead(list, 0);
        list.getHead().setNext(list.getHead());
        assertEquals(true, DetectLoopInLinkedList.execute(list.getHead()));
    }

    @Test
    public void detectLoop3() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        InsertionInSinglyLinkedList.insertAtHead(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        list.getHead().getNext().setNext(list.getHead());
        assertEquals(true, DetectLoopInLinkedList.execute(list.getHead()));
    }

    @Test
    public void detectLoop4() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        InsertionInSinglyLinkedList.insertAtHead(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        InsertionInSinglyLinkedList.insertAtEnd(list, 2);
        assertEquals(false, DetectLoopInLinkedList.execute(list.getHead()));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void detectLoop(int number) {

        assertEquals(false, DetectLoopInLinkedList.execute(list.getHead()));

        Node head = list.getHead();
        for (int i = 0; i < 9; i++) {
            head = head.getNext();
        }
        head.setNext(list.getHead());

        assertEquals(true, DetectLoopInLinkedList.execute(list.getHead()));
    }


}