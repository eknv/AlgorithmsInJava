package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.UndirectedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedComponentsTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        ConnectedComponents connectedComponents = new ConnectedComponents(graph);

        assertEquals("0 1 2 3 4", connectedComponents.calculate());
    }

}
