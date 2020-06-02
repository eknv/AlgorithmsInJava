package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.UndirectedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemovingEdgeCreateComponentTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        UndirectedGraph undirectedGraph = new UndirectedGraph(5);

        undirectedGraph.addEdge(0, 4);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);

        RemovingEdgeCreateComponent removingEdgeCreateComponent = new RemovingEdgeCreateComponent(undirectedGraph);
        assertTrue(removingEdgeCreateComponent.calculate(1, 2));
    }

}

