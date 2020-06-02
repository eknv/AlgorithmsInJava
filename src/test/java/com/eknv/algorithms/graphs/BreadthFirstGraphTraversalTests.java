package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadthFirstGraphTraversalTests {

    @BeforeAll
    static void setup() { }

    @Test
    void test1() {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        BreadthFirstGraphTraversal breadthFirstGraphTraversal = new BreadthFirstGraphTraversal(graph);

        assertEquals("2 0 3 1", breadthFirstGraphTraversal.calculate(2));

    }

}
