package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StronglyConnectedComponentsTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        StronglyConnectedComponents stronglyConnectedComponents = new StronglyConnectedComponents(graph);

        List<Queue<Integer>> connectedComponents = stronglyConnectedComponents.calculate();

        assertEquals("[[0, 1, 2], [3], [4]]", connectedComponents.toString());
    }


}

