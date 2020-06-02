package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchInSinglyLinkedListTests {

    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            InsertionInSinglyLinkedList.insertAtEnd(list, i);
        }
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void exists(int number) {
        assertEquals(number, BinarySearchInSinglyLinkedList.execute(list, number).getData());
    }

    @Test
    public void doesNotExist() {
        assertEquals(null, BinarySearchInSinglyLinkedList.execute(list, 11));
        assertEquals(null, BinarySearchInSinglyLinkedList.execute(list, -1));
    }


    private static IntStream dataProvider() {
        return IntStream.range(0, 10);
    }

}