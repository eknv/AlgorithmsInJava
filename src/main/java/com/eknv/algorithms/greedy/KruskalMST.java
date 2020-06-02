package com.eknv.algorithms.greedy;

import com.eknv.algorithms.graphs.model.Graph;
import com.eknv.algorithms.graphs.model.Subsets;
import com.eknv.algorithms.graphs.model.UndirectedGraph;

import java.util.Arrays;

/**
 * Kruskal's algorithm
 * Find Minimum Spanning Tree of a given connected, undirected and weighted graph
 */
public class KruskalMST {

    private Graph.Edge[] edges;
    private UndirectedGraph graph;
    private Subsets subsets;

    public KruskalMST(Graph.Edge[] edges) {
        this.edges = edges;
        this.graph = new UndirectedGraph(edges);
        this.subsets = new Subsets(graph, false);
    }


    public Graph.Edge[] calculate() {

        /**
         * this will store the resultant MST
         */
        Graph.Edge[] mstEdges = new Graph.Edge[graph.getNrOfVertices() - 1];

        /**
         * Sort all the edges in increasing order of their weight
         * If we are not allowed to change the given graph, we can create a copy of array of edges
         */
        Arrays.sort(edges);

        /**
         * index used to pick next edge
         */
        int edgeIndex = 0;
        int mstIndex = 0;

        /**
         * number of edges to be taken is equal to mstEdges length
         */
        while (mstIndex < mstEdges.length) {

            /**
             * Pick the smallest edge
             * increment the index for next iteration
             */
            Graph.Edge nextEdge = edges[edgeIndex++];

            /**
             * If including this edge does't cause cycle,
             * include it in result and increment the index
             * of result for next edge
             */
            int sourceRoot = subsets.root(nextEdge.getSrc());
            int destinationRoot = subsets.root(nextEdge.getDest());
            if (sourceRoot != destinationRoot) {
                mstEdges[mstIndex++] = nextEdge;
                subsets.union(sourceRoot, destinationRoot);
            }
        }

        return mstEdges;
    }

}

