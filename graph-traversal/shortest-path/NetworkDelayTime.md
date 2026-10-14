# Network Delay Time (LC 743)

**Problem:** A directed weighted network with nodes `1..n`; `times[i] = {u, v, w}` means a signal takes `w` to go `u → v`. A signal starts at node `k`. How long until **all** nodes have received it? Return `-1` if some node never does.

**Approach:** Run [Dijkstra](DijkstraAlgorithm.md) from `k`. The signal reaches a node at its shortest distance, so the total time is the **maximum** of all shortest distances. If any distance is still infinite, return `-1` → **O((V + E) log V)**.

**Intuition:** All nodes receive the signal along their fastest route, and the process ends when the **slowest** node is reached.

**Complexity:** Time O((V + E) log V), Space O(V + E).

**Edge cases:** A single node (0), an unreachable node (-1), a source with no outgoing edges, multiple routes (shortest wins).

**Interview traps**
- The answer is the **maximum** of the distances, **not the sum** and not the distance to a specific node.
- Nodes are **1-indexed**. Size arrays `n + 1` and ignore index 0.
- **Directed** edges only.
- Alternatives for small inputs: Bellman-Ford, Floyd-Warshall.

**How to explain:** "I find the shortest time from the source to every node with Dijkstra. The network is fully informed when the farthest node gets the signal, so I return the largest distance, or -1 if some node is unreachable."
