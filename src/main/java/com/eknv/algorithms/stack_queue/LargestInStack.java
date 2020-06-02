package com.eknv.algorithms.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You want to be able to access the largest element in a stack.
 * <p>
 * Use the built-in Stack class to implement a new class MaxStack with a method getMax()
 * that returns the largest element in the stack. getMax() should not remove the item.
 * <p>
 * Your stacks will contain only integers.
 */

public class LargestInStack {

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> maxStack = new LinkedList<>();

    public void push(int item) {
        stack.push(item);
        Integer currentMax = maxStack.peek();
        if (currentMax == null || item >= currentMax) {
            maxStack.push(item);
        }
    }

    public int pop() {
        Integer lastElement = stack.poll();
        if (lastElement == null) {
            return -1;
        }
        Integer currentMax = maxStack.peek();
        if (currentMax != null && lastElement.equals(currentMax)) {
            maxStack.remove(lastElement);
        }
        return lastElement;
    }

    public int getMax() {
        Integer max = maxStack.peek();
        return max == null ? -1 : max;
    }

}