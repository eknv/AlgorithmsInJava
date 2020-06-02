package com.eknv.algorithms.stack_queue;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement a queue with 2 stacks.
 * Your queue should have an enqueue and a dequeue method and it should be "first in first out" (FIFO).
 * Optimize for the time cost of m calls on your queue. These can be any mix of enqueue and dequeue calls.
 * Assume you already have a stack implementation and it gives O(1) time push and pop.
 */
public class QueueWithTwoStacks {


    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {

        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }

        inStack.push(item);
    }

    public int dequeue() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }

        return outStack.pop();
    }


}