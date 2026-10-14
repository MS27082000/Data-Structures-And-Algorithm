# Shortest Path in a Directed Acyclic Graph (DAG)

**Problem:** A weighted DAG and a source. Find the shortest distance from the source to every node (`-1` if unreachable).

**Approach:** **Topologically sort** the graph, then process nodes **in that order**, relaxing each node's outgoing edges (`dist[v] = min(dist[v], dist[u] + w)`). By the time a node is processed, every possible predecessor has already been processed, so its distance is final → **O(V + E)**.

**Why it beats Dijkstra:** No priority queue and it works with **negative edge weights** (a DAG has no cycles, so no negative cycle).

**Intuition:** In topological order, all paths into a node come from earlier nodes, so one forward sweep is enough.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** Unreachable nodes (skip nodes with infinite distance when relaxing), negative weights (fine), a single node, several components.

**Interview traps**
- **Skip `u` when `dist[u]` is infinite.** Relaxing from an unreachable node would overflow `INF + w`.
- It works only on **DAGs**. With cycles use Dijkstra / Bellman-Ford.
- The **longest** path in a DAG is the same algorithm with `max` (or negated weights).
- Process in topological order, **not** in index order.

**How to explain:** "I topologically sort the DAG and relax edges in that order. Each node is finalised after all its predecessors, so I get all shortest distances in linear time, even with negative weights."
