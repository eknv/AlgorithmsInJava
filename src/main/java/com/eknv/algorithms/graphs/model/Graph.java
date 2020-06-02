package com.eknv.algorithms.graphs.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

/**
 * Graph model
 */
public class Graph {

    protected int nrOfVertices;
    protected List<Integer>[] adjacents;

    public Graph(int[][] graph) {

        if (graph == null) {
            return;
        }

        init(graph.length);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != 0) {
                    addEdge(i, j);
                }
            }
        }
    }

    public Graph(Edge... edges) {

        if (edges == null) {
            return;
        }

        Set<Integer> nodes = new HashSet<>();

        for (Edge edge : edges) {
            nodes.add(edge.getSrc());
            nodes.add(edge.getDest());
        }

        init(nodes.size());

        for (Edge edge : edges) {
            addEdge(edge.getSrc(), edge.getDest());
        }
    }

    public Graph(int nrOfVertices) {
        init(nrOfVertices);
    }

    private void init(int vertices) {
        this.nrOfVertices = vertices;
        adjacents = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjacents[i] = new LinkedList<>();
    }

    public boolean hasEdge(int v, int w) {
        return adjacents[v].contains(w);
    }

    public void removeEdge(int v, int w) {
        adjacents[v].remove((Object) w);
    }

    public void addEdge(int v, int w) {
        adjacents[v].add(w);
    }

    public int getNrOfVertices() {
        return nrOfVertices;
    }


    public List<Integer>[] getAdjacentsArray() {
        return adjacents;
    }

    public List<Integer> getAdjacents(int node) {
        if (adjacents.length > node) {
            return adjacents[node];
        } else {
            return new LinkedList<>();
        }
    }

    public static String graphAsString(Graph graph) {
        StringBuilder sb = new StringBuilder();
        int nrOfVertices = graph.getNrOfVertices();
        for (int v = 0; v < nrOfVertices; v++) {
            sb.append(v + " --> ");
            Iterator<Integer> adjacentIt = graph.getAdjacents(v).iterator();
            while (adjacentIt.hasNext()) {
                sb.append(adjacentIt.next());
                if (adjacentIt.hasNext()) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Graph getTranspose(Graph graph) {
        int nrOfVertices = graph.getNrOfVertices();
        Graph transpose = new Graph(nrOfVertices);
        for (int vertex = 0; vertex < nrOfVertices; vertex++) {
            for (int adjacent : graph.getAdjacents(vertex)) {
                transpose.addEdge(adjacent, vertex);
            }
        }
        return transpose;
    }

    @Override
    public String toString() {
        return graphAsString(this);
    }

    public static class Edge implements Comparable<Edge> {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public Edge(int src, int dest, int weight) {
            this(src, dest);
            this.weight = weight;
        }

        public int getSrc() {
            return src;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(this.weight).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Edge)) {
                return false;
            }
            return new EqualsBuilder().append(this.weight, ((Edge) obj).weight).isEquals();
        }

        @Override
        public String toString() {
            return new StringBuilder().append(src).append(" -- ").append(dest).append(" == ").append(weight).toString();
        }
    }

}

