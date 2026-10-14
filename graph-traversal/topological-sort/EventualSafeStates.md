# Find Eventual Safe States (LC 802)

**Problem:** A directed graph. A **terminal** node has no outgoing edges. A node is **safe** if **every** path starting from it leads to a terminal node. Return all safe nodes in ascending order.

**Observation:** A node is **unsafe** iff it is on a cycle or can reach one.

**Approach 1 (reverse graph + Kahn):** Reverse every edge, and run Kahn's algorithm starting from the **terminal nodes** (out-degree 0 in the original). When a node's outgoing neighbours have all been proven safe (its out-degree count hits 0) it is safe too. Nodes never reaching out-degree 0 are on/behind a cycle → **O(V + E)**.
**Approach 2 (DFS, 3 states):** `unvisited / in progress / safe`. Reaching an in-progress node (a cycle) or an unsafe node marks the current node unsafe.

**Intuition:** Safety flows **backwards** from the terminals: a node is safe once all the places it can go are safe. That is a topological sort on the reversed graph.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** All terminal (all safe), a cycle (those nodes are unsafe), a node pointing into a cycle (unsafe), a self-loop (unsafe).

**Interview traps**
- It's the **out-degree** on the original graph, which becomes the in-degree on the reversed one.
- **Sort** the result (Kahn's order isn't ascending).
- Nodes that merely *lead to* a cycle are unsafe, not only the nodes on it.

**How to explain:** "I reverse the graph and peel nodes starting from the terminals. A node becomes safe when all of its outgoing neighbours are safe. Whatever never gets peeled is on, or leads into, a cycle."
