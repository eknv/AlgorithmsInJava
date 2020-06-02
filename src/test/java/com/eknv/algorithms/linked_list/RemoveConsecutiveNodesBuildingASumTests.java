package com.eknv.algorithms.linked_list;


import com.eknv.algorithms.linked_list.model.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveConsecutiveNodesBuildingASumTests {

    private Logger logger = LoggerFactory.getLogger(RemoveConsecutiveNodesBuildingASumTests.class);

    @Test
    public void test1() {

        // 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
        Node<Integer> head = new Node<>(10);
        head.next(5).next(-3).next(-3).next(1).next(4).next(-4);
        logger.debug(head.toString());

        assertEquals("10 -> null", RemoveConsecutiveNodesBuildingASum.execute(head).toString());
    }

    @Test
    public void test2() {

        // 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
        Node<Integer> head = new Node<>(0);
        head.next(0).next(-3).next(0).next(1).next(2).next(4).next(-4);
        logger.debug(head.toString());

        assertEquals(null, RemoveConsecutiveNodesBuildingASum.execute(head));
    }


}