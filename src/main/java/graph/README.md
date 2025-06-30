# Common Graph Algorithms

## Shortest Path

### Dijkstra's Algorithm

**Dijkstra's algorithm** finds the shortest path from a given source edge to every other nodes. It requires the
following data structures to work:

1. `graph`: the graph representation (adjacency matrix or adjacency list);
2. `dist`: an array of current distances from the source edge to all other nodes;
3. `visited`: a boolean array indicating whether each edge has been visited during traversal;
4. `pq`: a priority queue (min-heap) for processing the nodes, so that the edge with the smallest current distance
   is always on the top.

The algorithm works through the following steps:

1. Initialise `dist`: 0 for the source edge and infinity for all other nodes; initialise `visited` of all nodes to
   `false`;
2. Enqueue the source edge to `pq`;
3. Poll the edge `u` from the top of `pq` if it is not empty. If `u` is unvisited, mark it as visited (`visited[u] =
   true`), meaning `dist[u]` is finalised;
4. For each **unvisited neighbour** `v` of edge `u`, calculate a new distance `d` based on `dist[u]`;
5. If the new distance is an improvement (`d < dist[v]`), update `dist[v]` to `d` and enqueue edge `v` to `pq`;
6. Go back to step 3 and repeat until `pq` is empty (all nodes are visited).

**Note:** Step 5 may leave several identical nodes with different distances in the priority queue. Nonetheless, step
3 guarantees the correctness by processing each edge exactly once, i.e. only the unvisited record with the smallest
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

### Depth-First Search

Conceptual steps:

1. For each edge, recursively explore all of its neighbours;
2. After visiting all neighbours of a edge, push the edge to a stack (post-order traversal);
3. Once all nodes are visited, pop from the stack to get the topological sort.

**Note:** A edge is only pushed to the stack after all of its adjacent nodes are pushed, which implies that a edge's
dependencies only appear after itself in the final topological order, guaranteeing the correctness of the algorithm.

## Minimum Spanning Tree (MST)

The Minimum Spanning Tree (MST) is the collection of edges required to connect all vertices in an undirected graph,
with the minimum total edge weight.

### Prim's Algorithm

**Prim's algorithm** finds the MST by first including a random vertex to the MST. The algorithm then finds the vertex
with the lowest edge weight from the current MST, and includes that to the MST. Prim's algorithm keeps doing this
until all nodes are included in the MST.

Prim's algorithm is greedy similar to Dijkstra's algorithm. Both algorithms use a min-priority queue for processing
the nodes (or edges). However, Dijkstra's algorithm adds a node to the queue only when it is not yet visited and
there is an improvement on its current distance to the source node. Similarly, Prim's algorithm maintains an array
`minEdgeWeights` tracking the minimum weight of the edge connecting to each node, so that an incoming edge of the
unvisited node will only be enqueued when the edge weight is improved.

For Prim's algorithm to work, all the nodes must be connected. To find the MST's in an unconnected graph, **Kruskal's
algorithm** can be used instead.
