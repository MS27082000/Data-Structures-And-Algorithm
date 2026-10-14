# Cheapest Flights Within K Stops (LC 787)

**Problem:** Directed weighted flights `{from, to, price}`. Cheapest price from `src` to `dst` using **at most `k` stops** (so at most `k + 1` flights), or `-1`.

**Why plain Dijkstra fails:** The cheapest path might use too many stops, while a more expensive path with fewer stops is the valid one. The state must include the **number of stops**.

**Approach 1 (Bellman-Ford limited to k + 1 rounds):** In round `i`, `dist[v]` = cheapest price using **at most `i` flights**. Each round relaxes every edge **reading from the previous round's copy** of `dist` → **O(K · E)**.
**Approach 2 (BFS/level order):** Queue of `{node, cost}`; process `k + 1` levels, keeping the best cost per node.
**Approach 3:** Dijkstra with state `(node, stops)`.

**Intuition:** Bounding the number of edges is exactly what a fixed number of Bellman-Ford iterations gives.

**Complexity:** Time O(K · E), Space O(V).

**Edge cases:** `src == dst` (0), `k = 0` (direct flights only), unreachable (-1), a cheaper route that needs more stops than allowed.

**Interview traps**
- **Copy `dist` each round** (`next = dist.clone()`). Updating in place lets one round chain several flights and breaks the stop limit.
- It's `k + 1` flights for `k` stops.
- Check `dist[u] != INF` before relaxing to avoid overflow.
- Know **why Dijkstra by price alone is wrong** here. That's the usual follow-up.

**How to explain:** "I use Bellman-Ford but stop after k + 1 rounds, copying the distances each round so every round adds at most one flight. The value for the destination is the cheapest price within the stop limit."
