# Bridges in a Graph (Critical Connections, LC 1192)

**Problem:** In an undirected connected graph, a **bridge** is an edge whose **removal disconnects** the graph. Find all bridges.

**Brute force:** Remove each edge and test connectivity → O(E · (V + E)).
**Optimal (Tarjan's low-link DFS):** During one DFS keep, for each node,
- `tin[u]`: discovery time,
- `low[u]`: the **earliest discovery time reachable** from `u`'s DFS subtree using tree edges plus **one back edge**.
For a tree edge `u → v`: after recursing into `v`, `low[u] = min(low[u], low[v])`. The edge is a **bridge iff `low[v] > tin[u]`** (nothing in `v`'s subtree can reach `u` or above by another route) → **O(V + E)**.
For a **back edge** to an already-visited node `v` (not the parent): `low[u] = min(low[u], tin[v])`.

**Intuition:** An edge in a cycle can be bypassed, so it's not a bridge. `low[v] > tin[u]` says the subtree below `v` has no escape route past `u`.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** A tree (every edge is a bridge), a cycle (none), a single edge, a disconnected graph (run from every node), parallel edges (a duplicated edge is **not** a bridge).

**Interview traps**
- **Skip the parent edge** when scanning neighbours (otherwise the tree edge looks like a back edge).
- Condition is **`>`** for bridges (versus `>=` for [Articulation Points](ArticulationPoints.md)).
- Update `low[u]` with `low[v]` after the recursive call, with `tin[v]` for back edges.
- Deep graphs may overflow the recursion stack. Mention an iterative version.

**How to explain:** "I DFS and compute, for each node, the earliest discovery time reachable from its subtree using at most one back edge. A tree edge from u to v is a bridge when v's subtree can't reach u or anything earlier, i.e. low[v] > tin[u]."
