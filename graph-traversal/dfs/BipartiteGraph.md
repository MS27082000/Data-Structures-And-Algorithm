# Bipartite Graph (LC 785)

**Problem:** Can the nodes be split into **two groups** so that every edge connects nodes from **different** groups? Equivalently: can the graph be **2-coloured**?

**Key theorem:** A graph is bipartite **iff it has no odd-length cycle**.

**Approach (BFS/DFS colouring):** Colour the start node `0`. Give every neighbour the opposite colour `1 − c`. If a neighbour already has the **same** colour as the current node, the graph is **not** bipartite. Repeat from every uncoloured node (disconnected graphs) → **O(V + E)**.

**Intuition:** Colours must alternate along every path. Closing an odd cycle forces two adjacent nodes to share a colour.

**Complexity:** Time O(V + E), Space O(V).

**Edge cases:** No edges (bipartite), a disconnected graph where **each component is checked separately**, a self-loop (never bipartite), a tree (always bipartite), an even cycle (bipartite) vs odd cycle (not).

**Interview traps**
- **Handle every component.** One BFS from node 0 can miss an odd cycle elsewhere.
- Use `color[] = -1` for "unvisited", not `0`, since 0 is a real colour.
- A visited neighbour with the **opposite** colour is fine; only the **same** colour is a conflict.
- Applications: matching, "is it possible to divide into two teams?", scheduling conflicts.

**How to explain:** "I try to 2-colour the graph with BFS: each neighbour gets the opposite colour of the current node. If an edge ever joins two nodes of the same colour, there's an odd cycle and it's not bipartite."
