package graph.topologicalsorting;

import java.util.*;

public class DFS {

    /**
     * The DFS method for topological sorting. This recursive method applies post-order traversal.
     *
     * @param node    The graph node to explore
     * @param graph   The adjacency list representation of the graph
     * @param visited The boolean array indicating whether each node has been visited
     * @param stack   The stack maintaining the reverse topological order
     */
    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;
        for (int v : graph.get(node)) {
            if (!visited[v]) {
                dfs(v, graph, visited, stack);
            }
        }
        stack.push(node);
    }

    /**
     * DFS-based topological sorting.
     * <br/>
     * Precondition: The input graph is a DAG (Directed Acyclic Graph).
     *
     * @param graph The adjacency list representation of the graph
     * @return The topological order
     */
    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        // Maintain a stack keeping the reverse topological order
        Deque<Integer> stack = new ArrayDeque<>();

        // Conduct DFS for each unvisited node
        for (int node = 0; node < numNodes; node++) {
            if (!visited[node]) {
                dfs(node, graph, visited, stack);
            }
        }

        // Reverse the result list (pop the stack) to get the correct topological order
        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }

        return topoOrder;
    }

}
