package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HasCycleUndirectedGraphTests {


    @Test
    void test1() {

        /*
		0
		| \
		|  \
		1---2 */

        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        HasCycleUndirectedGraph hasCycleUndirectedGraph = new HasCycleUndirectedGraph(graph);

        assertEquals(true, hasCycleUndirectedGraph.calculate());
    }


    @Test
    void test2() {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);

        HasCycleUndirectedGraph hasCycleUndirectedGraph = new HasCycleUndirectedGraph(graph);

        assertEquals(false, hasCycleUndirectedGraph.calculate());
    }

}

