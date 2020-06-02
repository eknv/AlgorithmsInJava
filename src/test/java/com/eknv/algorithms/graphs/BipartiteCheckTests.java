package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BipartiteCheckTests {

    @BeforeAll
    static void setup() { }

    @Test
    void test1() {

        Graph graph = new Graph(new int[][]
                {
                        {0, 1, 0, 1},
                        {1, 0, 1, 0},
                        {0, 1, 0, 1},
                        {1, 0, 1, 0}
                });

        BipartiteCheck bipartiteCheck = new BipartiteCheck();

        assertTrue(bipartiteCheck.calculate(graph, 0));

    }

}
