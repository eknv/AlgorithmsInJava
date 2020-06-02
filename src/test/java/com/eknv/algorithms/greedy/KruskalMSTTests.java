package com.eknv.algorithms.greedy;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KruskalMSTTests {

    @Test
    public void test1() {

        /* Let us create following weighted graph
				10
			0-------1
			| \     |
		    6   5   15
			|	  \ |
			2-------3
				4     */

        Graph.Edge[] edges = new Graph.Edge[5];
        edges[0] = new Graph.Edge(0, 1, 10);
        edges[1] = new Graph.Edge(0, 2, 6);
        edges[2] = new Graph.Edge(0, 3, 5);
        edges[3] = new Graph.Edge(1, 3, 15);
        edges[4] = new Graph.Edge(2, 3, 4);
        KruskalMST kruskalMST = new KruskalMST(edges);
        assertEquals("[2 -- 3 == 4, 0 -- 3 == 5, 0 -- 1 == 10]", Arrays.toString(kruskalMST.calculate()));
    }

}