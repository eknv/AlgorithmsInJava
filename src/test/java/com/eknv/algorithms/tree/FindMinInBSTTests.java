package com.eknv.algorithms.tree;


import com.eknv.algorithms.tree.model.BST;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinInBSTTests {

    private static Logger logger = LoggerFactory.getLogger(FindMinInBST.class);

    private final static int MAX_NUMBER = 10;

    @Test
    void test1() {

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < MAX_NUMBER; i++) {
            bst.add(i);
        }

        assertEquals(0, FindMinInBST.execute(bst.getRoot()));
        assertEquals(-1, FindMinInBST.execute(null));
    }

    @Test
    void test2() {

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new TreeSet<>();
        Random random = new SecureRandom();
        BST<Integer> bst = new BST<>();

        /**
         * build a random tree
         * continue till all the numbers are added
         */
        while (set.size() != MAX_NUMBER) {
            int nextNumber = random.nextInt(MAX_NUMBER);
            sb.append(nextNumber).append(" ");
            //System.out.print(nextNumber);
            bst.add(nextNumber);
            set.add(nextNumber);
        }

        logger.debug(sb.toString());

        assertEquals(0, FindMinInBST.execute(bst.getRoot()));
    }

}
