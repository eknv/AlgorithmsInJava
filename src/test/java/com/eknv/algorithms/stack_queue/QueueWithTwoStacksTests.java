package com.eknv.algorithms.stack_queue;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Implement a queue with 2 stacks.
 * Your queue should have an enqueue and a dequeue method and it should be "first in first out" (FIFO).
 * Optimize for the time cost of m calls on your queue. These can be any mix of enqueue and dequeue calls.
 * Assume you already have a stack implementation and it gives O(1) time push and pop.
 */
public class QueueWithTwoStacksTests {

    @Test
    public void basicQueueOperationsTest() {
        final QueueWithTwoStacks q = new QueueWithTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test
    public void exceptionWhenDequeueFromNewQueueTest() {
        final QueueWithTwoStacks q = new QueueWithTwoStacks();
        assertThrows(Exception.class, () -> q.dequeue());
    }

    @Test
    public void exceptionWhenDequeueFromEmptyQueueTest() {
        final QueueWithTwoStacks q = new QueueWithTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        assertThrows(Exception.class, () -> q.dequeue());
    }


}