package com.eknv.algorithms.graphs;

import com.eknv.algorithms.graphs.model.UndirectedGraph;


public class RemovingEdgeCreateComponent {

    private UndirectedGraph graph;
    private boolean[] visited;

    public RemovingEdgeCreateComponent(UndirectedGraph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }

    public boolean calculate(int source, int destination) {

        graph.removeEdge(source, destination);

        /**
         * follow using depth first traversal
         */
        follow(0);

        return !allNodesVisited();
    }

    private void follow(int v) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int x : graph.getAdjacents(v)) {
            if (!visited[x]) {
                follow(x);
            }
        }
    }

    private boolean allNodesVisited() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}	 
