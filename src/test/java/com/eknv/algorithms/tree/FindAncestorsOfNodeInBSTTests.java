package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAncestorsOfNodeInBSTTests {


    private final static int maxNumber = 10;

    private BST<Integer> bst;

    @BeforeEach
    void setup() {
        bst = new BST<>();
        for (int i = 0; i < maxNumber; i++) {
            bst.add(i);
        }
    }

    @Test
    void test1() {
        assertEquals("[]", FindAncestorsOfNodeInBST.execute(bst.getRoot(), 10).toString());

        assertEquals("[0, 1, 2, 3, 4]", FindAncestorsOfNodeInBST.execute(bst.getRoot(), 5).toString());

        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", FindAncestorsOfNodeInBST.execute(bst.getRoot(), 9).toString());


    }


}
