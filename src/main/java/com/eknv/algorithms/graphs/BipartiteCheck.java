package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Find out whether a given graph is Bipartite or not
 * <p>
 * a bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint
 * and independent sets U and V such that every edge connects a vertex in U to one in V.
 */
public class BipartiteCheck {

    //

    /**
     * this function returns whether the given graph is bipartite
     */
    public boolean calculate(Graph graph, int src) {

        /**
         * Create a color array to store colors assigned to all vertices.
         * -1 = no color
         *  1 = first color
         *  2 = second color
         *
         *  We try to divide_conquer the graph into two sets, each set having its own color
         *  and then we'll check that no two edges have the same color
         */
        int[] colors = new int[graph.getNrOfVertices()];
        for (int i = 0; i < graph.getNrOfVertices(); i++)
            colors[i] = -1;

        // Assign first color to source
        colors[src] = 1;

        // Create a queue (FIFO) of vertex numbers
        // and enqueue source vertex for calculate traversal
        Deque<Integer> queue = new LinkedList<>();
        queue.add(src);

        // Run while there are vertices in queue (Similar to calculate)
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue
            int u = queue.poll();

            // Return false if there is a self-loop
            if (graph.hasEdge(u, u))
                return false;

            for (Integer adjacent : graph.getAdjacents(u)) {
                // An edge from u to v exists
                // and destination v is not colored
                if (colors[adjacent] == -1) {
                    // Assign alternate color to the adjacent node
                    colors[adjacent] = 1 - colors[u];
                    queue.add(adjacent);
                }

                /**
                 * if the edge has the same color, then it is in the same subset
                 * so this graph is not bipartite
                 */
                else if (colors[adjacent] == colors[u])
                    return false;
            }

        }

        /**
         * if we reach here, then all adjacent vertices can be colored with alternate color
         */
        return true;
    }

}

