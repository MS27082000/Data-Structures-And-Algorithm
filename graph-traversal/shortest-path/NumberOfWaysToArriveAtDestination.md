# Number of Ways to Arrive at Destination (LC 1976)

**Problem:** An undirected weighted graph (`n` intersections, `roads[i] = {u, v, time}`). Count the number of **different shortest paths** from node `0` to node `n − 1`, modulo 10⁹ + 7.

**Approach:** [Dijkstra](DijkstraAlgorithm.md) with an extra array `ways[]`:
- Found a **strictly shorter** path to `v` via `u` → `dist[v] = nd; ways[v] = ways[u]` (replace).
- Found an **equally short** path → `ways[v] = (ways[v] + ways[u]) % MOD` (add).
`ways[0] = 1` → **O((V + E) log V)**.

**Intuition:** Shortest paths into `v` are formed by extending shortest paths into its predecessors, so the counts add up exactly like in path-counting DP over the shortest-path DAG.

**Complexity:** Time O((V + E) log V), Space O(V + E).

**Edge cases:** A single node (1), a direct edge only, several equal paths, huge distances (use **`long`**).

**Interview traps**
- **Distances need `long`** (sums of up to 10⁹ edges). Counts need modulo.
- On a strictly better path **replace**; on a tie **add**. Mixing these up is the classic bug.
- Process a node's count only when its distance is final (skip stale heap entries).
- Don't reset `ways` on ties.

**How to explain:** "I run Dijkstra and keep, for each node, how many shortest paths reach it. When I find a shorter route I overwrite the count, and when I find an equal one I add to it."
