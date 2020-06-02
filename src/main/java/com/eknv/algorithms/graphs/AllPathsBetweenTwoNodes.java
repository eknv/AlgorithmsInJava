package com.eknv.algorithms.graphs;


import com.eknv.algorithms.graphs.model.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all paths from a source to destination.
 */
public class AllPathsBetweenTwoNodes {

    private Graph graph;
    private boolean[] visited;

    public AllPathsBetweenTwoNodes(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getNrOfVertices()];
    }


    public String calculate(int source, int destination) {
        List<Integer> currentPath = new ArrayList<>();

        currentPath.add(source);
        StringBuilder finishedPaths = new StringBuilder();
        follow(source, destination, currentPath, finishedPaths);
        return finishedPaths.toString();
    }


    private void follow(Integer source, Integer destination,
                        List<Integer> currentPath,
                        StringBuilder finishedPaths) {

        visited[source] = true;

        if (source.equals(destination)) {
            finishedPaths.append(currentPath.toString());
            visited[source] = false;
            return;
        }

        for (Integer neighbor : graph.getAdjacents(source)) {
            if (!visited[neighbor]) {
                currentPath.add(neighbor);
                follow(neighbor, destination, currentPath, finishedPaths);
                currentPath.remove(neighbor);
            }
        }

        visited[source] = false;
    }

}

