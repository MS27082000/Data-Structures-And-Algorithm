# Graph Traversal Techniques: BFS and DFS

**Goal:** Visit every node reachable from a start node exactly once.

## BFS (Breadth-First Search): a queue
- Visit the start, then **all its neighbours**, then their neighbours (level by level).
- Mark a node **visited when you enqueue it**, not when you dequeue it, so no node enters the queue twice.
- Gives the **shortest path in number of edges** in an unweighted graph.
- Use for: shortest path (unweighted), level order, multi-source spreading (rotten oranges), bipartite check.

## DFS (Depth-First Search): recursion or a stack
- Go as **deep** as possible along one path, then backtrack.
- Recursive is shortest to write; an **explicit stack** avoids stack overflow on deep graphs.
- Use for: connected components, cycle detection, topological sort, flood fill, bridges/articulation points, SCCs.

## Template
```java
// BFS
Queue<Integer> q = new ArrayDeque<>(); q.offer(s); visited[s] = true;
while (!q.isEmpty()) { int u = q.poll(); for (int v : adj.get(u)) if (!visited[v]) { visited[v] = true; q.offer(v); } }

// DFS
void dfs(int u) { visited[u] = true; for (int v : adj.get(u)) if (!visited[v]) dfs(v); }
```

## Disconnected graphs
Loop over **all** nodes and start a traversal from each unvisited one:
```java
for (int s = 0; s < n; s++) if (!visited[s]) { /* traverse from s: found one new component */ }
```

**Complexity:** Time **O(V + E)** (each node once, each edge once or twice). Space **O(V)** (visited + queue/stack/recursion).

**Edge cases:** Single node, no edges, disconnected graph, self-loops, a start node with no neighbours.

**Interview traps**
- **Visited on enqueue** for BFS. Marking on dequeue allows duplicates and can blow up.
- Undirected graphs need a **visited array** (or a parent check), otherwise infinite loops.
- Recursive DFS can hit the stack limit on a path of ~10⁵ nodes. Say you'd switch to an iterative stack.
- The visiting order depends on the **neighbour order** in the lists. Don't over-specify the output.
- BFS = shortest path **only if all edges cost the same**.

**How to explain:** "BFS uses a queue and explores level by level, so it finds shortest paths in unweighted graphs. DFS goes deep and backtracks, which suits connectivity and cycle problems. Both are O(V + E), and for disconnected graphs I start a traversal from every unvisited node."
