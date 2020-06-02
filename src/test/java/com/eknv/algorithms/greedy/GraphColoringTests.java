package com.eknv.algorithms.greedy;


import com.eknv.algorithms.graphs.model.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphColoringTests {

    @Test
    public void test1() {
        UndirectedGraph graph1 = new UndirectedGraph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        assertEquals("[0, 1, 2, 0, 1]", Arrays.toString(GraphColoring.calculate(graph1)));
    }

    @Test
    public void test2() {
        UndirectedGraph graph2 = new UndirectedGraph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 4);
        graph2.addEdge(4, 3);
        assertEquals("[0, 1, 2, 0, 3]", Arrays.toString(GraphColoring.calculate(graph2)));
    }

}