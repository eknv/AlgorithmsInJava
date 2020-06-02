package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKthMaxInBSTTests {


    private final static int MAX_NUMBER = 10;

    private BST<Integer> bst;

    @BeforeEach
    void setup() {
        bst = new BST<>();
        for (int i = 0; i < MAX_NUMBER; i++) {
            bst.add(i);
        }
    }

    @Test
    void test1() {
        assertEquals(null, FindKthMaxInBST.execute(bst.getRoot(), 10));
        assertEquals(null, FindKthMaxInBST.execute(bst.getRoot(), -1));

    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void existingNumbers(int number) {
        assertEquals(MAX_NUMBER - 1 - number, FindKthMaxInBST.execute(bst.getRoot(), number).getData());
    }


    private static IntStream dataProvider() {
        return IntStream.range(0, 10);
    }


}
