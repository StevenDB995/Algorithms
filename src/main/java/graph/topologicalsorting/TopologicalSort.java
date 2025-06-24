package graph.topologicalsorting;

import java.util.*;

public class TopologicalSort {

    /**
     * Kahn's Algorithm for topological sorting.
     * <br/>
     * Precondition: The input graph is a DAG (Directed Acyclic Graph).
     *
     * @param graph The adjacency list representation of the graph
     * @return The topological order
     */
    public static List<Integer> kahn(List<List<Integer>> graph) {
        int numNodes = graph.size();

        // Initialise in-degrees
        int[] indegrees = new int[numNodes];
        for (List<Integer> list : graph) {
            for (int v : list) {
                indegrees[v]++;
            }
        }

        // Initialise a queue by adding all the nodes with 0 in-degree
        Queue<Integer> q = new ArrayDeque<>();
        for (int v = 0; v < numNodes; v++) {
            if (indegrees[v] == 0) {
                q.offer(v);
            }
        }

        // Process the queue and output the topological sort
        List<Integer> topoSort = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topoSort.add(u);
            for (int v : graph.get(u)) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return topoSort;
    }

}
