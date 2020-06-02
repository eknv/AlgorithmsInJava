package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MiddleNodeOfLinkedListTests {

    private SinglyLinkedList<Integer> list;


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void test1(int number) {

        list = new SinglyLinkedList<>();

        for (int i = 0; i < number; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }

        assertEquals((number - 1) / 2, MiddleNodeOfLinkedList.calculate(list.getHead()).getData());
    }

    @Test
    public void loopDetection() {

        list = new SinglyLinkedList<>();
        InsertionInSinglyLinkedList.insertAtHead(list, 0);
        InsertionInSinglyLinkedList.insertAtEnd(list, 1);
        list.getHead().getNext().setNext(list.getHead());

        assertThrows(Exception.class, () -> MiddleNodeOfLinkedList.calculate(list.getHead()));
    }


}