# Topological Sort (DFS) and Kahn's Algorithm (BFS)

**Problem:** In a **DAG**, produce a linear ordering of the nodes such that for every edge `u → v`, `u` appears **before** `v`. (Think "course prerequisites", "build order".)

**Kahn's algorithm (BFS on in-degrees):**
1. Compute the in-degree of every node.
2. Queue all nodes with in-degree 0.
3. Pop a node, append it to the order, and **decrease the in-degree** of its neighbours; enqueue any that reach 0.
4. If fewer than `V` nodes were output, there is a **cycle** (no topological order) → **O(V + E)**.

**DFS version:** DFS every unvisited node; when a node **finishes** (all descendants done) push it on a stack. Popping the stack gives a valid order → O(V + E). It does not detect cycles by itself.

**Intuition:** A node with in-degree 0 has nothing that must come before it, so it can safely go first. Removing it may free others.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** No edges (any order), a cycle (Kahn returns fewer than V nodes), disconnected DAGs, one node.

**Interview traps**
- **Only DAGs** have a topological order. Kahn's algorithm doubles as a **cycle detector** for directed graphs.
- The order is **not unique**. Validate your answer by checking that every edge goes forward, not by comparing with a fixed list.
- DFS: push to the stack **after** exploring the neighbours, not before.
- Used by: Course Schedule, Alien Dictionary, build systems, DP on DAGs, [shortest path in a DAG](ShortestPathInDAG.md).

**How to explain:** "Repeatedly take a node with no remaining prerequisites, output it, and remove its outgoing edges. If I can output every node there's a valid order; if I get stuck, there's a cycle."
