package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Traverse a graph breadth first and return the nodes in that order
 */
public class BreadthFirstGraphTraversal {

    private Graph graph;

    public BreadthFirstGraphTraversal(Graph graph) {
        this.graph = graph;
    }

    // prints calculate traversal from a given source s
    public String calculate(int source) {

        List<Integer> nodes = new ArrayList<>();

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[graph.getNrOfVertices()];

        // Create a queue for calculate
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            source = queue.poll();
            nodes.add(source);

            /**
             * Get all adjacent vertices of the dequeued vertex source
             * If a adjacent has not been visited, then mark it
             * visited and enqueue it
             */
            for (Integer adjacent : graph.getAdjacents(source)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }

        return nodes.stream().map(Object::toString).collect(Collectors.joining(" "));

    }

}
