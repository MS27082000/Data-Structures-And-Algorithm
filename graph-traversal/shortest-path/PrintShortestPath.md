# Print Shortest Path

**Problem:** Nodes `1..n`, undirected weighted edges. Return the **actual shortest path** from node `1` to node `n` (as a list of nodes), or `[-1]` if unreachable.

**Approach:** Run [Dijkstra](DijkstraAlgorithm.md) and keep a **`parent` array**: whenever `dist[v]` improves via `u`, set `parent[v] = u`. After the run, **walk back from `n` to `1`** following `parent`, collecting nodes, then **reverse** the list → **O((V + E) log V)**.

**Intuition:** The parent array stores the last edge of the best path to each node, so following it backwards reconstructs the whole path.

**Complexity:** Time O((V + E) log V), Space O(V + E).

**Edge cases:** No path (`dist[n]` still infinite → `[-1]`), `n == 1` (path is `[1]`), several equally short paths (any is acceptable), parallel edges.

**Interview traps**
- Initialise `parent[i] = i` and stop the walk at the **source**.
- Update `parent` **only when the distance strictly improves**.
- The path comes out **reversed**. Reverse it.
- Nodes are **1-indexed** here, so size arrays `n + 1`.
- The same `parent` trick works for BFS paths (unit weights).

**How to explain:** "I run Dijkstra and remember, for each node, which node gave it its best distance. From the destination I follow those parents back to the source and reverse the result to get the path."
