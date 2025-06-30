package graph.mst;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

    static class Edge implements Comparable<Edge> {
        int to; // the node to which the edge connects
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }

    public static int[] getMinimumSpanningTree(int[][] graph) {
        int numNodes = graph.length;
        boolean[] visited = new boolean[numNodes];
        // The minimum weight of the edge that connects to each node
        int[] minEdgeWeights = new int[numNodes];
        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        int[] parents = new int[numNodes];
        Arrays.fill(parents, -1);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;

            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < numNodes; v++) {
                // Continue to process the node v only when:
                // 1. it is not yet visited and;
                // 2. its minimum edge weight is improved.
                if (graph[u][v] > 0 && !visited[v] && graph[u][v] < minEdgeWeights[v]) {
                    pq.offer(new Edge(v, graph[u][v]));
                    minEdgeWeights[v] = graph[u][v];
                    parents[v] = u;
                }
            }
        }

        return parents;
    }

}
