package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphStronglyConnectedTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);

        GraphStronglyConnected graphStronglyConnected = new GraphStronglyConnected(graph);

        assertEquals(true, graphStronglyConnected.calculate());
    }

    @Test
    void test2() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        GraphStronglyConnected graphStronglyConnected = new GraphStronglyConnected(graph);

        assertEquals(false, graphStronglyConnected.calculate());
    }

}

