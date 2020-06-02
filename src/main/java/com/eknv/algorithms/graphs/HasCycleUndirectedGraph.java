package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;
import com.eknv.algorithms.graphs.model.Subsets;

/**
 * Union-root algorithm to detect cycle in an undirected graph
 */
class HasCycleUndirectedGraph {

    private Graph graph;
    private Subsets subsets;

    public HasCycleUndirectedGraph(Graph graph) {
        this.graph = graph;
        this.subsets = new Subsets(graph, false);
    }

    public boolean calculate() {

        /**
         * iterate through and each neighbors
         * get the roots of both edges
         * if they have the same root, then they belong to the same subset and so we have a cycle
         */

        for (int v = 0; v < graph.getNrOfVertices(); v++) {

            int sourceRoot = subsets.root(v);
            for (int adjacent : graph.getAdjacents(v)) {
                int adjacentRoot = subsets.root(adjacent);
                if (sourceRoot == adjacentRoot) {
                    return true;
                }
                subsets.union(sourceRoot, adjacentRoot);
            }

        }

        return false;
    }

} 
