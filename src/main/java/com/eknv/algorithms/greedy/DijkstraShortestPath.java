package com.eknv.algorithms.greedy;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

/**
 * Given a graph and a source vertex in the graph,
 * find shortest paths from source to all vertices in the given graph.
 */
public class DijkstraShortestPath {

    private int[] distances;
    private Set<Integer> alreadyProcessed;
    private PriorityQueue<Node> toBeProcessed;

    private int nrOfVertices;
    private Map<Integer, List<Node>> adjacents;

    public DijkstraShortestPath(int nrOfVertices, Map<Integer, List<Node>> adjacents) {
        this.nrOfVertices = nrOfVertices;
        this.adjacents = adjacents;
        this.distances = new int[nrOfVertices];
        this.alreadyProcessed = new HashSet<>();
        this.toBeProcessed = new PriorityQueue<>(nrOfVertices);
    }

    // function for Dijkstra's algorithm
    public int[] calculate(int sourceId) {

        for (int i = 0; i < nrOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        // add source node to the priority queue
        toBeProcessed.add(new Node(sourceId, 0));

        // distance to the source is 0
        distances[sourceId] = 0;

        while (alreadyProcessed.size() != nrOfVertices) {

            // get the node with smallest distance from the queue
            Node nodeWithSmallestDistance = toBeProcessed.remove();

            // adding the node whose distance is finalized
            alreadyProcessed.add(nodeWithSmallestDistance.getNodeId());

            processNode(nodeWithSmallestDistance.getNodeId());
        }

        return distances;
    }


    /**
     * function to process all the neighbours of the passed node
     */
    private void processNode(int nodeId) {

        // all the neighbors of v
        for (Node adjacent : adjacents.get(nodeId)) {

            // if current node hasn't already been processed
            if (!alreadyProcessed.contains(adjacent.getNodeId())) {

                int newDistance = distances[nodeId] + adjacent.getDistance();

                // if new distance is smaller
                if (newDistance < distances[adjacent.getNodeId()]) {
                    distances[adjacent.getNodeId()] = newDistance;
                }

                // add the current node to the queue
                toBeProcessed.add(new Node(adjacent.getNodeId(), distances[adjacent.getNodeId()]));
            }
        }
    }

    /**
     * Class to represent a node in the graph
     */
    public static class Node implements Comparable<Node> {
        private int nodeId;
        private int distance;

        public Node(int nodeId, int distance) {
            this.nodeId = nodeId;
            this.distance = distance;
        }

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(this.distance).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                return false;
            }
            return new EqualsBuilder().append(this.distance, ((Node) obj).getDistance()).isEquals();
        }
    }


}

