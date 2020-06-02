package com.eknv.algorithms.graphs;

import com.eknv.algorithms.graphs.model.Graph;

import java.util.*;

/**
 * Java implementation of Kosaraju's algorithm to print all SCCs
 */
public class StronglyConnectedComponents {

    private Graph graph;
    private boolean[] visited;

    public StronglyConnectedComponents(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
    }


    /**
     * The main function that finds and prints all strongly
     * connected components
     */
    public List<Queue<Integer>> calculate() {
        Deque<Integer> stack = new ArrayDeque<>();

        // topological sorting, fill the vertices in the stack according to their finishing times aka.
        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            if (!visited[i]) {
                fillOrder(i, stack);
            }
        }

        /**
         * Create a reversed graph
         */
        graph = Graph.getTranspose(graph);

        // Mark all the vertices as not visited (For second DFS)
        Arrays.fill(visited, false);


        List<Queue<Integer>> connectedComponents = new ArrayList<>();
        // Now process all vertices in order defined by Stack
        while (!stack.isEmpty()) {
            // Pop a vertex from stack
            int v = stack.pop();

            Queue<Integer> queue = new LinkedList<>();
            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                // depth first follow
                follow(v, queue);
                connectedComponents.add(queue);
            }
        }
        return connectedComponents;
    }


    private void follow(int v, Queue<Integer> queue) {
        visited[v] = true;
        queue.add(v);

        for (int w : graph.getAdjacents(v)) {
            if (!visited[w]) {
                follow(w, queue);
            }
        }
    }


    private void fillOrder(int v, Deque<Integer> stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int w : graph.getAdjacents(v)) {
            if (!visited[w]) {
                fillOrder(w, stack);
            }
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(v);
    }

}
