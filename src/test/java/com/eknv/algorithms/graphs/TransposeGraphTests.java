package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransposeGraphTests {

    @BeforeAll
    static void setup() {
    }

    @Test
    void test1() {

        /**
         * 0 --> 1 4 3
         * 1 -->
         * 2 --> 0
         * 3 --> 2
         * 4 --> 1 3
         */
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 2);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);

        TransposeGraph transposeGraph = new TransposeGraph(graph);
        Graph transposed = transposeGraph.calculate();

        String expectedResult = "0 --> 2\n" +
                "1 --> 0 4\n" +
                "2 --> 3\n" +
                "3 --> 0 4\n" +
                "4 --> 0\n";

        assertEquals(expectedResult, transposed.toString());
    }

}
