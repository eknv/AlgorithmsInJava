package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Calculate depth traversal from a given graph
 */
class DepthFirstGraphTraversal {

    private Graph graph;
    private List<String> nodes = new ArrayList<>();
    private boolean[] visited;

    public DepthFirstGraphTraversal(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }

    // The function to do calculate traversal. It uses recursive follow()
    public String calculate(int v) {

        // Call the recursive helper function to print calculate traversal
        follow(v);
        return nodes.stream().collect(Collectors.joining(" "));
    }

    // A function used by calculate
    private void follow(int v) {

        // Mark the current node as visited and print it
        visited[v] = true;

        nodes.add(String.valueOf(v));

        // Recur for all the vertices adjacent to this vertex
        for (int node : graph.getAdjacents(v)) {
            if (!visited[node]) {
                follow(node);
            }
        }
    }

}

