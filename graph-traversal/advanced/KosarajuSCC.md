# Kosaraju's Algorithm (Strongly Connected Components)

**Problem:** In a **directed** graph, a **strongly connected component (SCC)** is a maximal set of nodes in which every node can reach every other. Find all SCCs.

**Algorithm (3 steps):**
1. **DFS the original graph** and push each node on a stack **when it finishes**.
2. **Transpose** the graph (reverse every edge).
3. **Pop** nodes from the stack; for each node not yet visited run a **DFS on the transposed graph**. Everything that DFS visits is **one SCC**.
→ **O(V + E)**.

**Why it works:** SCCs form a DAG when contracted. The node that finishes last in step 1 belongs to a **source** SCC. After reversing edges, that SCC can only reach **itself**, so the DFS on the transpose stays inside it. Removing it exposes the next one.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** A DAG (every node is its own SCC), one big cycle (a single SCC), isolated nodes, self-loops.

**Interview traps**
- **The finishing-order stack** (push after exploring neighbours) is crucial, not the discovery order.
- Run the second DFS on the **transpose**, not the original.
- The number of SCCs is the number of second-phase DFS launches.
- Alternative: **Tarjan's** algorithm (one DFS with low-link values, no transpose).
- Applications: 2-SAT, condensing a graph into a DAG, finding groups of mutually reachable pages/modules.

**How to explain:** "I DFS the graph and record nodes in order of finishing. Then I reverse all edges and pop nodes from that order, running a DFS on the reversed graph from each unvisited one. Each such DFS covers exactly one strongly connected component."
