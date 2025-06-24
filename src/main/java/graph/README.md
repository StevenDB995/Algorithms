# Common Graph Algorithms

## Shortest Path

### Dijkstra's Algorithm

**Dijkstra's algorithm** finds the shortest path from a given source node to every other nodes. It requires the 
following data structures to work:

1. `graph`: the graph representation (adjacency matrix or adjacency list);
2. `dist`: an array of current distances from the source node to all other nodes;
3. `visited`: a boolean array indicating whether each node has been visited during traversal;
4. `pq`: a priority queue (min-heap) for processing the nodes, so that the node with the smallest current distance 
   is always on the top.

The algorithm works through the following steps:

1. Initialise `dist`: 0 for the source node and infinity for all other nodes; initialise `visited` of all nodes to 
   `false`;
2. Enqueue the source node to `pq`;
3. Poll the node `u` from the top of `pq` if it is not empty. If `u` is unvisited, mark it as visited (`visited[u] = 
   true`), meaning `dist[u]` is finalised;
4. For each **unvisited neighbour** `v` of node `u`, calculate a new distance `d` based on `dist[u]`;
5. If the new distance is an improvement (`d < dist[v]`), update `dist[v]` to `d` and enqueue node `v` to `pq`;
6. Go back to step 3 and repeat until `pq` is empty (all nodes are visited).

**Note:** Step 5 may leave several identical nodes with different distances in the priority queue. Nonetheless, step 
3 guarantees the correctness by processing each node exactly once, i.e. only the unvisited record with the smallest 
distance will be processed.

Dijkstra's algorithm does not work for graphs with negative edges, while **Bellman-Ford algorithm** handles this use 
case well.

Dijkstra's algorithm is a greedy algorithm.

## Topological Sorting

A topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that for every
directed edge `(u, v)` from vertex `u` to vertex `v`, `u` comes before `v` in the ordering.

For example, for the following graph:

```
A → D → E
    ↑
B → C
```

There are three possible topological sorts:
```
A, B, C, D, E
B, C, A, D, E
B, A, C, D, E
```

A topological sort is possible if and only if the graph is a directed acyclic graph (DAG).

### Kahn's Algorithm

**Kahn's algorithm** repeatedly finds vertices with no incoming edges, removes them from the graph and updates the 
in-degrees of the vertices connected from the removed edges. This process repeats until all vertices are processed.

Note that most textbooks or learning materials describe the process as 'removing the vertices from the graph', which 
can be misleading, because in fact the algorithm is implemented by maintaining an in-degree list and updating it 
after processing each vertex, instead of modifying the original graph.

Kahn's algorithm is BFS-based (Breadth-First Search).
