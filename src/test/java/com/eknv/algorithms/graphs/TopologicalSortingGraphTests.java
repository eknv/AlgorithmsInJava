package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopologicalSortingGraphTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        /**
         * 0 -->
         * 1 -->
         * 2 --> 3
         * 3 --> 1
         * 4 --> 0 1
         * 5 --> 2 0
         */
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopologicalSortingGraph topologicalSortingGraph = new TopologicalSortingGraph(graph);
        assertEquals("5 4 2 3 1 0", topologicalSortingGraph.calculate());
    }

    @Test
    void test2() {

        /**
         * 0 --> 1 3
         * 1 --> 2
         * 2 --> 3 4
         * 3 --> 4
         * 4 -->
         */
        Graph graph = new Graph(5);
        graph.addEdge(0 ,1);
        graph.addEdge(1 ,2);
        graph.addEdge(2 ,3);
        graph.addEdge(2 ,4);
        graph.addEdge(3, 4);
        graph.addEdge(0, 3);

        TopologicalSortingGraph topologicalSortingGraph = new TopologicalSortingGraph(graph);
        assertEquals("0 1 2 3 4", topologicalSortingGraph.calculate());
    }

}

