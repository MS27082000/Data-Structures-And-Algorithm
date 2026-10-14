# Find the City With the Smallest Number of Neighbours at a Threshold Distance (LC 1334)

**Problem:** An undirected weighted graph of cities. For each city count the other cities reachable within **shortest-path distance ≤ `distanceThreshold`**. Return the city with the **fewest** such neighbours; on a tie, the city with the **greatest number**.

**Approach:** Compute **all-pairs shortest paths** with [Floyd-Warshall](FloydWarshall.md), then for each city count the others within the threshold, and pick the minimum (using `<=` so a later city wins ties) → **O(V³)**.
**Alternative:** Run Dijkstra from every city: O(V · (V + E) log V). Better for large sparse graphs.

**Intuition:** "Reachable within a distance" refers to **shortest** paths between **all** pairs, which is exactly what Floyd-Warshall computes.

**Complexity:** Time O(V³) (Floyd), Space O(V²).

**Edge cases:** No edges (everyone has 0 neighbours → the greatest index), one city, everyone reaches everyone (tie → the greatest index), a threshold smaller than every edge.

**Interview traps**
- **Tie-breaking:** the **greater** index wins, so use `count <= best`.
- Distances use **shortest** paths, not direct edges.
- The graph is **undirected**: fill both `dist[u][v]` and `dist[v][u]`.
- Use a safe `INF` to avoid overflow when adding.

**How to explain:** "I compute the shortest distance between every pair of cities with Floyd-Warshall, count how many cities are within the threshold from each one, and choose the city with the smallest count, preferring the larger index on ties."
