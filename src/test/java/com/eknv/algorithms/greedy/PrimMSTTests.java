package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimMSTTests {

    @Test
    public void test() {

        /*
		    2     3
		(0)---(1)---(2)
		|    / \    |
	   6|  8/   \5  |7
		|  /	 \  |
		(3)--------(4)
			  9		 */

        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        assertEquals("0 - 1 == 2, 1 - 2 == 3, 0 - 3 == 6, 1 - 4 == 5", PrimMST.calculate(graph));
    }

}