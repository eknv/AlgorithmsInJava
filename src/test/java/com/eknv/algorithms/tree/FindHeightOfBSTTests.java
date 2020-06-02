package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindHeightOfBSTTests {


    @Test
    void test1() {

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 10; i++) {
            bst.add(i);
        }

        assertEquals(9, FindHeightOfBST.execute(bst.getRoot()));
    }


    @Test
    void test2() {

        BST<Integer> bst = new BST<>();
        bst.add(0);
        bst.add(5);
        bst.add(3);
        bst.add(2);
        bst.add(4);

        assertEquals(3, FindHeightOfBST.execute(bst.getRoot()));
    }


    @Test
    void test3() {

        BST<Integer> bst = new BST<>();
        bst.add(4);
        bst.add(5);
        bst.add(2);
        bst.add(1);
        bst.add(3);

        assertEquals(2, FindHeightOfBST.execute(bst.getRoot()));
    }


    @Test
    void test4() {

        BST<Integer> bst = new BST<>();
        bst.add(0);

        assertEquals(0, FindHeightOfBST.execute(bst.getRoot()));
    }


    @Test
    void test5() {

        BST<Integer> bst = new BST<>();
        bst.add(0);
        bst.getRoot().insertRight(1);

        assertEquals(1, FindHeightOfBST.execute(bst.getRoot()));
    }


}
