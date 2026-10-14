# Detect a Cycle in a Directed Graph

**Problem:** Does a directed graph contain a cycle?

**Approach 1 (DFS with 3 states):** For each node keep `0 = unvisited`, `1 = on the CURRENT recursion path`, `2 = completely explored`. While exploring `u`, reaching a neighbour in state `1` means an edge back to an **ancestor on the current path** → **cycle**. Mark `u` as `2` when leaving it → **O(V + E)**.
**Approach 2 (Kahn's algorithm):** Repeatedly remove in-degree-0 nodes. If fewer than `V` nodes are removed, the rest lie on or behind a cycle ([Topological Sort](../topological-sort/TopologicalSortKahn.md)).

**Why a plain `visited[]` is wrong:** In a directed graph a node can be reached by **two different paths** without any cycle (a diamond `0→1→3`, `0→2→3`). Reaching an already-visited node is only a cycle if it is **still on the current path**.

**Complexity:** Time O(V + E), Space O(V).

**Edge cases:** Self-loop (`u → u`), a 2-cycle, a cycle in a different component, a DAG with a diamond (no cycle).

**Interview traps**
- The **path-visited** (state 1) array, reset on backtrack, is the whole point.
- Undirected cycle detection (parent check) does **not** apply here.
- Both methods need a loop over every node.
- This is the core of Course Schedule I/II and Eventual Safe States.

**How to explain:** "I DFS and keep track of the nodes on the current recursion path. If I reach a node that is on that path, there's a back edge, so a cycle. A node visited earlier via another branch is fine."
