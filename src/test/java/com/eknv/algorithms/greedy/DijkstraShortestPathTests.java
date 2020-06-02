package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraShortestPathTests {

    @Test
    public void test() {

        int nrOfVertices = 5;
        int source = 0;

        Map<Integer, List<DijkstraShortestPath.Node>> adjacents = new HashMap<>();

        for (int i = 0; i < nrOfVertices; i++) {
            List<DijkstraShortestPath.Node> edges = new ArrayList<>();
            adjacents.put(i, edges);
        }

        adjacents.put(0, Arrays.asList(
                new DijkstraShortestPath.Node(1, 9),
                new DijkstraShortestPath.Node(2, 6),
                new DijkstraShortestPath.Node(3, 5),
                new DijkstraShortestPath.Node(4, 3)
        ));
        adjacents.get(2).addAll(Arrays.asList(
                new DijkstraShortestPath.Node(1, 2),
                new DijkstraShortestPath.Node(3, 4)
        ));

        DijkstraShortestPath dpq = new DijkstraShortestPath(nrOfVertices, adjacents);

        assertEquals("[0, 8, 6, 5, 3]", Arrays.toString(dpq.calculate(source)));
    }

}