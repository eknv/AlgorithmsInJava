package com.eknv.algorithms.linked_list;

/**
 * Find a duplicate, Space Edition™ BEAST MODE
 * <p>
 * We are given an array of integers where:
 * <p>
 * the integers are in the range 1..n1
 * the array has a length of n+1
 * <p>
 * These properties mean the array must have at least 1 duplicate.
 * Our challenge is to find a duplicate number, while optimizing for space.
 * <p>
 * We should find a duplicate integer in O(n) time while keeping our space cost at O(1).
 */
public class FindDuplicate {

    private FindDuplicate() {
    }

    /**
     * this problem can be solved by taking this array as a linked-list
     * where the values at each index is pointing to the next index in the list
     * here we would need to look for a cycle in this list,
     * this is where two entries are pointing to the same index and causing a cycle (the duplicate)
     *
     * note that this works
     */
    public static int execute(int[] nums) {

        /**
         * first, find the intersection point of the two runners
         */
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);


        /**
         * then find the starting point of the cycle
         * by setting the tortoise back to the beginning
         * and let them both run with slow pace
         */
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
