# Detect a Cycle in an Undirected Graph

**Problem:** Does an undirected graph contain a cycle?

**Approach (DFS with a parent):** Carry the **parent** of each node. While exploring `u`, for each neighbour `v`:
- unvisited → recurse with parent `u`;
- **visited and `v != parent`** → we reached a node already on our traversal that isn't the one we came from → a **back edge → cycle**.
Run from every unvisited node (the graph may be disconnected) → **O(V + E)**.

**BFS version:** Queue of `{node, parent}` with the same rule.
**Union-Find version:** For each edge, if both ends are already in the same set → cycle.

**Intuition:** In an undirected tree every edge is traversed once from the parent and the only "visited neighbour" is the parent itself. Any other visited neighbour closes a loop.

**Complexity:** Time O(V + E), Space O(V).

**Edge cases:** Disconnected graph (cycle in the second component), self-loop, **parallel edges** (a repeated pair is a 2-node cycle; the simple parent check misses it), a single node, a tree (no cycle).

**Interview traps**
- **Exclude the parent.** Otherwise every edge looks like a cycle (`u–v` seen from `v`).
- Loop over **all** components.
- Don't reuse this for **directed** graphs: use three-colour DFS or Kahn's algorithm instead ([Directed version](CycleDetectionDirected.md)).
- A graph with `E ≥ V` edges in a component must contain a cycle.

**How to explain:** "I DFS, remembering the node I came from. If I find a visited neighbour that isn't my parent, I've found a back edge, so there's a cycle. I start a DFS from every unvisited node to cover all components."
