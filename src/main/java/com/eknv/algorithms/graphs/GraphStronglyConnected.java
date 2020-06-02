package com.eknv.algorithms.graphs;

import com.eknv.algorithms.graphs.model.Graph;

/**
 * Check whether a given directed graph is strongly connected or not
 * A graph is said to be strongly connected if every vertex is reachable from every other vertex.
 */
public class GraphStronglyConnected {

    private Graph graph;
    private boolean[] visited;

    public GraphStronglyConnected(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }

    private void follow(int v) {

        visited[v] = true;

        for (int node : graph.getAdjacents(v)) {
            if (!visited[node]) {
                follow(node);
            }
        }
    }

    private boolean allNodesVisited() {
        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean calculate() {

        follow(0);

        /**
         * If calculate traversal doesn't visit all vertices, then return false.
         */
        if (!allNodesVisited()) {
            return false;
        }

        // create a reversed graph
        this.graph = Graph.getTranspose(graph);

        // reset the visited array
        for (int i = 0; i < graph.getNrOfVertices(); i++)
            visited[i] = false;

        // follow the first vertex in the reversed graph
        // staring Vertex must be same starting point of first calculate
        follow(0);

        // graph is strongly connected if all vertices are also visited in the second graph
        return allNodesVisited();
    }

}

