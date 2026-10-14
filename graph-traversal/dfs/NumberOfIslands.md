# Number of Islands (LC 200)

**Problem:** A grid of `'1'` (land) and `'0'` (water). An **island** is a group of land cells connected **horizontally or vertically**. Count the islands.

**Approach:** The grid is an implicit graph (cells are nodes, the 4 neighbours are edges). Scan every cell. On an unvisited `'1'`, **count++ and flood-fill** the island with DFS/BFS, marking cells as visited (overwrite with `'0'`, or use a `visited` matrix) → **O(R·C)** time.

**Intuition:** Sinking the island after counting it guarantees each island is counted exactly once.

**Complexity:** Time O(R·C), Space O(R·C) recursion in the worst case (a snake-shaped island). Use BFS or an explicit stack to avoid deep recursion.

**Edge cases:** All water (0), all land (1), diagonal land cells (**not** connected), a 1×1 grid, single row/column.

**Interview traps**
- **Four** directions, not eight. (LC 200 forbids diagonal connections.)
- Mark visited **before** recursing (or on entry) to avoid infinite recursion.
- Overwriting the input mutates it. Say so, or use a `visited` array if the grid must stay intact.
- Characters `'1'`/`'0'`, not ints (a classic compile/logic slip).
- Follow-ups: [Number of Islands II](../union-find/NumberOfIslandsII.md) (online), [Distinct Islands](NumberOfDistinctIslands.md), max area of an island.

**How to explain:** "I scan the grid; each time I hit land I haven't visited, I add one to the count and flood-fill that island so its cells aren't counted again."
