# Floyd-Warshall Algorithm

**Problem:** Shortest distances between **all pairs** of nodes. Handles negative edges and detects negative cycles.

**Algorithm (DP over intermediate nodes):** `dist[i][j]` starts as the direct edge weight (∞ if none, 0 on the diagonal). For each node **`k`** as a possible intermediate stop, for every pair `(i, j)`:
`dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`.
After processing all `k`, `dist[i][j]` is the shortest path using any intermediate nodes → **O(V³)**.

**Intuition:** After the `k`-th round, `dist[i][j]` is the best path whose intermediate nodes are all among the first `k` nodes. Allowing one more intermediate either keeps the old path or splits it at `k`.

**Complexity:** Time O(V³), Space O(V²) (done in place).

**Negative cycle:** After the run, `dist[i][i] < 0` for some `i`.

**Edge cases:** Unreachable pairs (stay ∞), self-distances 0, parallel edges (keep the minimum), disconnected graphs.

**Interview traps**
- **`k` must be the OUTERMOST loop.** Putting it inside gives wrong answers.
- Use a **safe INF** (e.g. 10⁹, not `Integer.MAX_VALUE`) and skip `INF` terms so additions don't overflow.
- Good for **small V** (≈ 400 or fewer) or dense graphs. For one source use Dijkstra.
- To print paths, keep a `next[i][j]` matrix.
- Also used for transitive closure (Warshall: boolean OR/AND).

**How to explain:** "I let each node act as an intermediate stop in turn and check whether going through it shortens any pair's distance. Three nested loops with the intermediate node outermost give all-pairs shortest paths in O(V³)."
