package com.eknv.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Prim's Minimum Spanning Tree (PrimMST) algorithm
 */
public class PrimMST {

    private PrimMST() {
    }


    /**
     * Function to construct and print PrimMST for a graph represented
     * using adjacency matrix representation
     */
    public static String calculate(int[][] graph) {

        int numberOfVertices = graph.length;

        // array to store constructed PrimMST
        int[] parents = new int[numberOfVertices];
        // key values used to pick minimum weight edge in cut
        int[] weights = new int[numberOfVertices];
        // to represent set of vertices not yet included in PrimMST
        Boolean[] mstSet = new Boolean[numberOfVertices];

        // initialize all keys as INFINITE
        for (int i = 0; i < numberOfVertices; i++) {
            weights[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first vertex in PrimMST.
        weights[0] = 0; // Make key 0 so that this vertex is picked as first vertex
        parents[0] = -1; // First node is always root of PrimMST

        // The PrimMST will have V vertices
        for (int i = 0; i < numberOfVertices - 1; i++) {
            // Pick the minimum key vertex from the set of vertices
            // not yet included in PrimMST
            int pickedNode = minKey(weights, mstSet);

            // Add the picked vertex to the PrimMST Set
            mstSet[pickedNode] = true;

            /**
             * Update key value and parent index of the adjacent vertices of the picked vertex.
             * Consider only those vertices which are not yet included in PrimMST
             */
            for (int v = 0; v < numberOfVertices; v++) {
                /**
                 * graph[u][v] is non zero only for adjacent vertices
                 * mstSet[v] is false for vertices not yet included in PrimMST
                 * Update the key only if graph[u][v] is smaller than key[v]
                 */
                if (graph[pickedNode][v] != 0
                        && Boolean.FALSE.equals(mstSet[v])
                        && graph[pickedNode][v] < weights[v]) {
                    parents[v] = pickedNode;
                    weights[v] = graph[pickedNode][v];
                }
            }


        }

        return printPrimMST(parents, graph);
    }


    /**
     * A utility function to find the vertex with minimum key
     * value, from the set of vertices not yet included in PrimMST
     */
    private static int minKey(int[] key, Boolean[] mstSet) {

        int numberOfVertices = key.length;

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numberOfVertices; v++) {
            if (Boolean.FALSE.equals(mstSet[v]) && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }


    /**
     * a utility function to print the constructed PrimMST stored in parent[]
     */
    private static String printPrimMST(int[] parent, int[][] graph) {
        List<String> paths = new ArrayList<>();
        for (int i = 1; i < graph.length; i++) {
            paths.add(new StringBuilder().append(parent[i]).append(" - ").append(i)
                    .append(" == ").append(graph[i][parent[i]]).toString());
        }
        return paths.stream().collect(Collectors.joining(", "));
    }

}
