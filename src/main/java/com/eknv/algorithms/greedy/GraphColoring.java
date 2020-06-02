package com.eknv.algorithms.greedy;

import com.eknv.algorithms.graphs.model.UndirectedGraph;

import java.util.Arrays;


/**
 * Given an undirected graph with n vertices
 * Assign a color to each of the nodes so that no adjacent nodes have the same color
 * Try to use least amount of colors as possible
 */
public class GraphColoring {

    private GraphColoring() {
    }

    /**
     * @param graph
     * @return the color assignments
     */
    public static int[] calculate(UndirectedGraph graph) {

        int[] takenColors = new int[graph.getNrOfVertices()];

        /**
         * initialize all colors as unassigned
         */
        Arrays.fill(takenColors, -1);

        /**
         * first vertex get the color 0
         */
        takenColors[0] = 0;

        /**
         * boolean array to keep track of the already assigned colors for the respective neighboring vertices
         */
        boolean[] available = new boolean[graph.getNrOfVertices()];
        /**
         * at the beginning, all colors are available
         */
        Arrays.fill(available, true);

        for (int u = 1; u < graph.getNrOfVertices(); u++) {

            /**
             * for each node, go through the vertices
             * if a color the neighbor has a color, set the respective color as taken
             */
            for (int adjacentId : graph.getAdjacents(u)) {
                int adjacentColor = takenColors[adjacentId];
                if (adjacentColor != -1) {
                    available[adjacentColor] = false;
                }
            }

            /**
             * go through all the colors, and take the first available one
             */
            int colorIndex;
            for (colorIndex = 0; colorIndex < graph.getNrOfVertices(); colorIndex++) {
                if (available[colorIndex]) {
                    break;
                }
            }

            /**
             * set the color of this vertex to the available index
             */
            takenColors[u] = colorIndex;

            /**
             * reset the values back to true for the next iteration
             */
            Arrays.fill(available, true);
        }

        return takenColors;

    }

}
