package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

/**
 * Detect cycle in a directed graph
 */
public class HasCycleDirectedGraph {

    private Graph graph;
    /**
     * set for the whole depth traversal
     */
    private boolean[] visited;
    /**
     * set for each depth dives
     */
    private boolean[] recursionStack;

    public HasCycleDirectedGraph(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNrOfVertices()];
        this.recursionStack = new boolean[graph.getNrOfVertices()];
    }

    public boolean calculate() {

        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            if (isCyclicUtil(i)) {
                return true;
            }
        }

        return false;
    }


    private boolean isCyclicUtil(int node) {

        /**
         * we do a depth first search
         * if we see a node again,
         * then we have a cycle
         */
        if (recursionStack[node]) {
            return true;
        }

        /**
         * if we have seen this node before,
         * in any of the depth dives,
         * ignore it, we do not need to repeat ourselves
         */
        if (visited[node]) {
            return false;
        }

        /**
         * Mark the current node as visited and
         * part of recursion stack
         */
        visited[node] = true;
        recursionStack[node] = true;

        for (Integer adjacent : graph.getAdjacents(node)) {
            if (isCyclicUtil(adjacent)) {
                return true;
            }
        }

        /**
         * as coming back from a depth dive,
         * reset the recursion stack for the respective nodes
         */
        recursionStack[node] = false;

        return false;
    }

} 
