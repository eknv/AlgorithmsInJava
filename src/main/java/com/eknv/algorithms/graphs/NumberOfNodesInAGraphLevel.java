package com.eknv.algorithms.graphs;

import com.eknv.algorithms.graphs.model.Graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Calculate number of nodes in a given graph level
 */
class NumberOfNodesInAGraphLevel {

    private Graph graph;
    private boolean[] visited;

    public NumberOfNodesInAGraphLevel(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }

    public int calculate(int source, int level) {

        int[] levels = new int[graph.getNrOfVertices()];

        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            levels[i] = 0;
        }

        // Create a queue for calculate
        Deque<Integer> queue = new LinkedList<>();

        // Mark the current node as
        // visited and enqueue it
        visited[source] = true;
        queue.push(source);
        levels[source] = 0;

        while (!queue.isEmpty()) {

            /**
             * Dequeue a vertex from queue and print it
             */
            source = queue.pop();

            /**
             * Get all adjacent vertices of the dequeued vertex source
             * If a adjacent has not been visited, then mark it visited and enqueue it
             * Enqueue it so that its adjacent will be examined the same way
             */
            for (int adjacent : graph.getAdjacents(source)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    levels[adjacent] = levels[source] + 1;
                    queue.push(adjacent);
                }
            }

        }

        int count = 0;
        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            if (levels[i] == level) {
                count++;
            }
        }

        return count;
    }

}

