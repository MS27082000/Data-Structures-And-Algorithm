# Shortest Path in an Undirected Graph with Unit Weights

**Problem:** Every edge has weight 1. Find the shortest distance from a source to **every** node (`-1` if unreachable).

**Approach:** **BFS** from the source. BFS visits nodes in increasing order of distance, so the **first time** a node is reached is its shortest distance (`dist[v] = dist[u] + 1`) → **O(V + E)**.

**Intuition:** Level `k` of BFS holds exactly the nodes at distance `k`.

**Complexity:** Time O(V + E), Space O(V).

**Edge cases:** Unreachable nodes (-1), a single node, the source with no edges, cycles (the visited check handles them).

**Interview traps**
- **Unit weights only.** With different weights BFS is wrong and you need [Dijkstra](../shortest-path/DijkstraAlgorithm.md) (or 0-1 BFS for weights 0/1).
- Initialise `dist = -1` and use it as the visited marker.
- To recover the **path** (not just the distance) store a `parent` array.
- Undirected: add each edge both ways.

**How to explain:** "With equal edge costs, BFS explores nodes in order of distance, so the first time I reach a node is the shortest path to it. I record the distance when I enqueue the node."
