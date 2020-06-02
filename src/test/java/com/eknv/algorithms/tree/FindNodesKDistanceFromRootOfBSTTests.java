package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.BST;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindNodesKDistanceFromRootOfBSTTests {


    @Test
    void test1() {

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 10; i++) {
            bst.add(i);
        }

        assertEquals("[2]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 2).toString());
    }

    @Test
    void test2() {

        BST<Integer> bst = new BST<>();
        bst.add(0);
        bst.add(5);
        bst.add(3);
        bst.add(2);
        bst.add(4);

        assertEquals("[3]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 2).toString());
        assertEquals("[2, 4]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 3).toString());
    }

    @Test
    void test3() {

        BST<Integer> bst = new BST<>();
        bst.add(4);
        bst.add(5);
        bst.add(2);
        bst.add(1);
        bst.add(3);

        assertEquals("[1, 3]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 2).toString());
        assertEquals("[]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 3).toString());
    }

    @Test
    void test4() {

        BST<Integer> bst = new BST<>();
        bst.add(0);

        assertEquals("[0]", FindNodesKDistanceFromRootOfBST.execute(bst.getRoot(), 0).toString());
    }

    @Test
    void testNullRoot() {

        BST<Integer> bst = new BST<>();
        bst.add(0);

        assertEquals(new ArrayList<>(), FindNodesKDistanceFromRootOfBST.execute(null, 0));
    }


}
