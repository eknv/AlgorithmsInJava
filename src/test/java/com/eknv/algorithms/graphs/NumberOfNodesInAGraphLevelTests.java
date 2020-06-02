package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfNodesInAGraphLevelTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        NumberOfNodesInAGraphLevel numberOfNodesInAGraphLevel = new NumberOfNodesInAGraphLevel(graph);

        assertEquals(2, numberOfNodesInAGraphLevel.calculate(0,1));
        assertEquals(0, numberOfNodesInAGraphLevel.calculate(0,2));
        assertEquals(0, numberOfNodesInAGraphLevel.calculate(0,3));
    }

}

