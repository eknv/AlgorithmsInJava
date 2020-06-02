package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllPathsBetweenTwoNodesTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);

        AllPathsBetweenTwoNodes allPathsBetweenTwoNodes = new AllPathsBetweenTwoNodes(graph);

        assertEquals("[2, 0, 1, 3][2, 0, 3][2, 1, 3]", allPathsBetweenTwoNodes.calculate(2, 3));

    }

}
