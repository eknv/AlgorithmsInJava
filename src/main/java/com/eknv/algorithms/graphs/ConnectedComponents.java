package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Print connected components in an undirected graph
 */
public class ConnectedComponents {

    private UndirectedGraph graph;
    private List<String> nodes = new ArrayList<>();
    boolean[] visited;

    public ConnectedComponents(UndirectedGraph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }


    public String calculate() {

        // Mark all the vertices as not visited
        for (int v = 0; v < graph.getNrOfVertices(); ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                follow(v);
            }
        }

        return nodes.stream().collect(Collectors.joining(" "));
    }


    private void follow(int node) {
        // Mark the current node as visited and print it
        visited[node] = true;
        nodes.add(String.valueOf(node));

        // Recur for all the vertices
        // adjacent to this vertex
        for (int adjacent : graph.getAdjacents(node)) {
            if (!visited[adjacent]) {
                follow(adjacent);
            }
        }

    }

}	 
