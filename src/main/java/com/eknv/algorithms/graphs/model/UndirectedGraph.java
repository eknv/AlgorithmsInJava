package com.eknv.algorithms.graphs.model;


/**
 * Undirected Graph model
 */
public class UndirectedGraph extends Graph {


    public UndirectedGraph(int nrOfVertices) {
        super(nrOfVertices);
    }

    public UndirectedGraph(Edge... edges) {
        super(edges);
    }

    @Override
    public void addEdge(int node1, int node2) {
        adjacents[node1].add(node2);
        adjacents[node2].add(node1);
    }

    @Override
    public void removeEdge(int node1, int node2) {
        adjacents[node1].remove((Object) node2);
        adjacents[node2].remove((Object) node1);
    }

}

