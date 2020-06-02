package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HasCycledirectedGraphTests {


    @Test
    void test1() {

        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        HasCycleDirectedGraph hasCycleDirectedGraph = new HasCycleDirectedGraph(graph);

        assertEquals(false, hasCycleDirectedGraph.calculate());
    }

}

