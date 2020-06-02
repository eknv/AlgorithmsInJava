package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Calculates the topological sorting of a DAG
 * <p>
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv,
 * vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 */
public class TopologicalSortingGraph {

    private Graph graph;
    private boolean[] visited;


    public TopologicalSortingGraph(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }


    public String calculate() {
        Deque<Integer> stack = new ArrayDeque<>();

        /**
         * Call the recursive helper function to store topological sort starting from all vertices one by one
         */
        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            if (!visited[i]) {
                follow(i, stack);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }


    /**
     * A recursive function used by calculate
     */
    private void follow(int node, Deque<Integer> stack) {

        /**
         * mark the current node as visite
         */
        visited[node] = true;

        /**
         * recur for all the vertices adjacent to this
         */
        for (int w : graph.getAdjacents(node)) {
            if (!visited[w]) {
                follow(w, stack);
            }
        }

        /**
         * note that the deepest node will be inserted first into the deque and will be retrieved last
         */
        stack.push(node);
    }

}

