# Articulation Points (Cut Vertices)

**Problem:** An **articulation point** is a node whose **removal increases the number of connected components** of an undirected graph. Find all of them.

**Brute force:** Remove each node and count components → O(V · (V + E)).
**Optimal (Tarjan's low-link DFS):** Same `tin[]` / `low[]` as [Bridges](BridgesInGraph.md). For a DFS tree:
- **Non-root node `u`:** it is an articulation point if **some DFS child `v` has `low[v] >= tin[u]`** (the subtree of `v` can reach `u` at best, never above it).
- **Root:** it is an articulation point if it has **more than one DFS child** (the children are only connected through the root).
→ **O(V + E)**.

**Intuition:** If a child's subtree cannot reach any ancestor of `u` by another route, deleting `u` cuts that subtree off.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** A star (the centre), a path (inner nodes), a cycle (none), two nodes (none), a node that is an articulation point through several children (add it **once**: use a Set).

**Interview traps**
- **`>=` here, `>` for bridges.** (A cut vertex only needs the subtree to be unable to reach *above* `u`; reaching `u` itself still isolates it once `u` is removed.)
- **Treat the DFS root separately** (child count > 1). Applying the normal test to the root wrongly marks it.
- Skip the **parent** when scanning neighbours.
- Collect results in a `Set` and run the DFS from every unvisited node.

**How to explain:** "I DFS and compute discovery times and low-links. A non-root node is a cut vertex if a child's subtree can't climb above it, and the root is one if it has more than one DFS child, because then its subtrees connect only through it."
