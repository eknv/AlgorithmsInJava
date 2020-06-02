package com.eknv.algorithms.graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.
 * <p>
 * Instead of routing texts through cell towers, your app sends messages via the phones of nearby users,
 * passing each message along from one phone to the next until it reaches the intended recipient.
 * (Don't worry—the messages are encrypted while they're in transit.)
 * <p>
 * Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered.
 * After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.
 * <p>
 * Given information about active users on the network,
 * find the shortest route for a message from one user (the sender) to another (the recipient).
 * Return an array of users that make up this route.
 * <p>
 * There might be a few shortest delivery routes, all with the same length.
 * For now, let's just return any shortest route.
 * <p>
 * Your network information takes the form of a hash map mapping username strings to an array of other users nearby:
 * <p>
 * Map<String, String[]> network = new HashMap<String, String[]>() {{
 * put("Min",     new String[] { "William", "Jayden", "Omar" });
 * put("William", new String[] { "Min", "Noam" });
 * put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
 * put("Ren",     new String[] { "Jayden", "Omar" });
 * put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
 * put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
 * put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
 * put("Noam",    new String[] { "Nathan", "Jayden", "William" });
 * put("Omar",    new String[] { "Ren", "Min", "Scott" });
 * ...
 * }};
 * <p>
 * For the network above, a message from Jayden to Adam should have this route:
 * <p>
 * { "Jayden", "Amelia", "Adam" }
 */
public class MeshMessage {

    private static Logger logger = LoggerFactory.getLogger(MeshMessage.class);

    private MeshMessage() {
    }

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        Assert.notNull(graph, "graph");

        Assert.isTrue(graph.containsKey(startNode) && graph.containsKey(endNode),
                "graph.containsKey(startNode) && graph.containsKey(endNode)");

        /**
         * visited map to avoid loops
         */
        Map<String, Boolean> visited = new HashMap<>();
        initVisitedMap(visited, graph);

        /**
         * Lists to keep track of the paths
         */
        List<List<String>> allFinishedPaths = new ArrayList<>();
        List<String> currentPaths = new ArrayList<>();
        currentPaths.add(startNode);

        /**
         * capture the paths
         */
        follow(graph, startNode, endNode, visited, allFinishedPaths, currentPaths);


        /**
         * return null, if no path could be found
         */
        if (allFinishedPaths.isEmpty()) {
            return new String[]{};
        }

        /**
         * just debugging
         */
        if (allFinishedPaths.size() > 1) {
            logger.debug("From {} to {} with {} different paths: {}",
                    startNode, endNode, allFinishedPaths.size(), allFinishedPaths);
        }

        /**
         * take the shortest path
         * one with the least amount of stops
         */
        int shortestLength = Integer.MAX_VALUE;
        List<String> shortestPath = null;
        for (int i = 0; i < allFinishedPaths.size(); i++) {
            List<String> finishedPath = allFinishedPaths.get(i);
            if (finishedPath.size() < shortestLength) {
                shortestPath = finishedPath;
                shortestLength = finishedPath.size();
            }
        }

        return shortestPath != null ? shortestPath.toArray(new String[shortestPath.size()]) : new String[]{};
    }


    public static void follow(
            Map<String, String[]> graph,
            String startNode,
            String endNode,
            Map<String, Boolean> visited,
            List<List<String>> allFinishedPaths,
            List<String> currentPaths) {

        visited.put(startNode, true);

        if (startNode.equals(endNode)) {
            allFinishedPaths.add(new ArrayList<>(currentPaths));
            return;
        }

        for (String adjacent : graph.get(startNode)) {
            if (Boolean.FALSE.equals(visited.get(adjacent))) {
                currentPaths.add(adjacent);
                follow(graph, adjacent, endNode, visited, allFinishedPaths, currentPaths);
                currentPaths.remove(adjacent);
            }
        }

        visited.put(startNode, false);
    }


    private static void initVisitedMap(Map<String, Boolean> visited, Map<String, String[]> graph) {
        for (String node : graph.keySet()) {
            visited.put(node, false);
        }
    }


}