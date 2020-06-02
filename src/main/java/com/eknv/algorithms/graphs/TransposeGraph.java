package com.eknv.algorithms.graphs;

import com.eknv.algorithms.graphs.model.Graph;

/**
 * This class calculates the transpose of the give graph
 */
public class TransposeGraph {

    private Graph graph;

    public TransposeGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph calculate() {
        /**
         * check the following method for the implementation
         */
        return Graph.getTranspose(graph);
    }

}
