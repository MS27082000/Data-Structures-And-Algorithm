# Bellman-Ford Algorithm

**Problem:** Single-source shortest paths in a graph that may have **negative edge weights**, and detect **negative cycles**.

**Algorithm:**
1. `dist[src] = 0`, others ∞.
2. Repeat **`V − 1`** times: relax **every** edge `(u, v, w)`: `if dist[u] + w < dist[v] → dist[v] = dist[u] + w`.
3. Do **one more pass**. If any edge can still be relaxed → there is a **negative cycle** reachable from the source.

**Why `V − 1` rounds:** A shortest path (without a cycle) has at most `V − 1` edges, and round `i` finalises all shortest paths that use `i` edges.

**Complexity:** Time **O(V · E)**, Space O(V). Early exit if a round changes nothing.

**Edge cases:** Unreachable nodes (stay at ∞; don't relax from them), a negative cycle **not** reachable from the source (no effect on the answer), undirected negative edges (an undirected negative edge is itself a negative cycle).

**Interview traps**
- Skip edges whose source is still infinite (`INF + w` overflow, wrong distances).
- The detection pass matters. Without it a negative cycle silently gives garbage.
- Use it when edges can be negative; otherwise [Dijkstra](DijkstraAlgorithm.md) is faster.
- Variants: limit the rounds to `k` ([Cheapest Flights](CheapestFlightsWithinKStops.md)); SPFA (queue-based) is faster in practice.
- To list nodes affected by a negative cycle, keep relaxing and flag nodes still improving after `V` rounds.

**How to explain:** "I relax all edges V − 1 times, which is enough for shortest paths of up to V − 1 edges. If a further pass still improves some distance, a negative cycle exists. It's slower than Dijkstra but handles negative weights."
