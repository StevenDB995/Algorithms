package graph.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Node implements Comparable<Node> {
        int name;
        int distance;

        Node(int name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }
    }

    /**
     * Dijkstra algorithm finding the shortest path to each graph node given a source node.
     * <br/>
     * Precondition: All edge weights are non-negative.
     *
     * @param graph The adjacency matrix of the graph. graph[u][v] = 0 indicates the edge does not exist.
     * @param src   The source node
     * @return The list of shortest distances from src to each node
     */
    public static int[] dijkstra(int[][] graph, int src) {
        // Initialise:
        // 1. all dist as ∞, except for the source node as 0;
        // 2. all visited as false
        int numNodes = graph.length;
        int[] dist = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.name;

            // Mark visited[u] as true when the shortest path to node u is finalised.
            // The same node with difference distance may be added while exploring the shortest path.
            // Therefore, we need to skip the node if its shortest path has already been found.
            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < numNodes; v++) {
                if (graph[u][v] > 0 && !visited[v]) {
                    int d = dist[u] + graph[u][v];
                    if (d < dist[v]) {
                        dist[v] = d;
                        pq.offer(new Node(v, d));
                    }
                }
            }
        }

        return dist;
    }

}
