# Shortest Distance in a Binary Maze

**Problem:** A grid of `1` (open) and `0` (blocked). Find the fewest 4-directional steps from a source cell to a destination cell, or `-1`.

**Approach:** Every move costs 1, so **BFS** is already optimal (a Dijkstra with all weights 1 is just BFS). Keep a `dist` matrix initialised to `-1` (the visited marker); the first time the destination is reached its distance is the answer → **O(R·C)**.

**Intuition:** BFS expands in rings of equal distance from the source, so the first arrival at the destination is the shortest.

**Complexity:** Time O(R·C), Space O(R·C).

**Edge cases:** Source equals destination (0), source or destination blocked (-1), destination walled off (-1), a one-cell maze.

**Interview traps**
- **BFS, not DFS.** DFS finds *a* path, not the shortest.
- A priority queue (Dijkstra) works but is unnecessary overhead for unit costs.
- **Check source/destination validity** first.
- Four directions only (unless the problem allows diagonals; LC 1091 does with 8).
- For weighted cells (different costs) switch to [Dijkstra](DijkstraAlgorithm.md).

**How to explain:** "Each step costs one, so I BFS from the source over open cells. The first time I dequeue the destination, the distance recorded is the shortest path length."
