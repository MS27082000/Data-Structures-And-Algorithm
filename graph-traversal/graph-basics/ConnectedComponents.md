# Connected Components

**Problem:** Count (and list) the connected components of an undirected graph. A component is a maximal set of nodes where each pair is connected by a path.

**Approach:** Keep a `visited` array. For every node `s`: if it is unvisited, **start a DFS (or BFS) from it**. That traversal reaches exactly the nodes of `s`'s component, so increment the counter once per start → **O(V + E)** time, O(V) space.

**Intuition:** A traversal can't leave its component, and each start point is the first node of a **new** component.

**Alternatives:** **Union-Find**: union every edge, then count the roots (also dynamic: supports adding edges online). See [Disjoint Set](../union-find/DisjointSet.md).

**Complexity:** Time O(V + E), Space O(V).

**Edge cases:** No edges (V components), one node, a fully connected graph (1), the empty graph (0).

**Interview traps**
- **Loop over all nodes.** One traversal from node 0 only covers one component.
- Count components, **not** nodes or edges visited.
- A connected graph with `V` nodes has at least `V − 1` edges; with `c` components at least `V − c`.
- This is the base for [Number of Provinces](../dfs/NumberOfProvinces.md), [Number of Islands](../dfs/NumberOfIslands.md), and "make the network connected".

**How to explain:** "I walk the nodes in order. Each time I find one I haven't visited, I flood-fill its whole component with DFS and count one more component."
