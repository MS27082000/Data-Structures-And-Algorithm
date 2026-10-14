# M-Coloring Problem

**Problem:** Given an undirected graph with `V` vertices and `m` colours, can you colour the vertices so that **no two adjacent vertices share a colour**?

**Brute force:** Try all `m^V` colourings and validate each → O(m^V · V²).
**Optimal (backtracking):** Colour vertices one by one. For vertex `v` try colours `1..m`; use a colour only if **no neighbour already has it**; recurse to `v + 1`; if no colour works, backtrack.

**Intuition:** Checking only already-coloured neighbours prunes any partial colouring that is already invalid, long before all vertices are coloured.

**Complexity:** Time O(m^V) worst case (heavily pruned), Space O(V) for the colour array and stack.

**Edge cases:** Single vertex (true), no edges (true with 1 colour), complete graph `K_n` needs `n` colours, a triangle fails with 2 colours, an even cycle works with 2.

**Interview traps**
- It is an **NP-complete** decision problem. No polynomial-time algorithm is known (and mention the 4-colour theorem for planar graphs).
- Reset the colour to `0` when backtracking.
- With an adjacency **matrix**, the safety check is O(V). With an adjacency list it's O(deg).
- A graph is 2-colourable iff it is **bipartite** (BFS/DFS in O(V+E)). Know that special case.

**How to explain:** "I colour vertices in order, giving each the first colour no neighbour uses, and backtrack when a vertex has no available colour. If all vertices get coloured, the answer is yes."
