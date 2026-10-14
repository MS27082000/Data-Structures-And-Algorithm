# Number of Provinces (LC 547)

**Problem:** `isConnected[i][j] = 1` means cities `i` and `j` are directly connected. A **province** is a group of cities connected directly or indirectly. Count the provinces.

**Approach:** The input is an **adjacency matrix**, so this is "count connected components". DFS (or BFS) from every unvisited city, marking all cities reachable from it. Each start = one province → **O(V²)** time (the matrix scan), O(V) space.
**Alternative:** Union-Find over the edges, then count components.

**Intuition:** A traversal cannot leave its group, so the number of traversals launched equals the number of groups.

**Complexity:** Time O(V²) with a matrix (O(V + E) with a list), Space O(V).

**Edge cases:** All isolated (V provinces), all connected (1), a single city, the diagonal `isConnected[i][i] = 1` (ignore or visit harmlessly).

**Interview traps**
- It is an **adjacency matrix**, not a grid of land cells. Neighbours of `i` are all `j` with `isConnected[i][j] == 1`.
- Don't count the nodes, count the **number of traversal starts**.
- The matrix is symmetric, so no direction handling is needed.

**How to explain:** "Cities and direct links form an undirected graph and a province is a connected component. I run DFS from each unvisited city and count how many times I have to start."
