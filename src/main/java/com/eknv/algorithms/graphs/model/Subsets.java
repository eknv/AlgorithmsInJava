package com.eknv.algorithms.graphs.model;


/**
 * Subsets
 */
public class Subsets {

    private int[] parents;
    private Graph graph;

    public Subsets(Graph graph, boolean initialize) {
        if (graph == null) {
            throw new IllegalStateException("Graph cannot be null");
        }
        this.graph = graph;
        parents = new int[graph.getNrOfVertices()];
        for (int i = 0; i < graph.getNrOfVertices(); i++) {
            parents[i] = -1;
        }
        if (initialize) {
            initialize();
        }
    }

    private void initialize() {
        for (int v = 0; v < graph.getNrOfVertices(); v++) {
            int source = root(v);
            for (int w : graph.getAdjacents(v)) {
                int destination = root(w);
                if (source != destination) {
                    union(source, destination);
                }
            }

        }
    }

    public int root(int node) {
        if (parents[node] == -1)
            return node;
        return root(parents[node]);
    }

    public void union(int node1, int node2) {
        int xset = root(node1);
        int yset = root(node2);
        parents[xset] = yset;
    }

}

