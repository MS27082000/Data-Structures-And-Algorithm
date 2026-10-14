# Most Stones Removed with Same Row or Column (LC 947)

**Problem:** Stones sit at integer grid points. A stone can be **removed** if another stone **remaining** shares its **row or column**. Return the maximum number of stones you can remove.

**Key insight:** Stones sharing a row or column form **connected groups**. Within a group of `k` stones you can remove **`k − 1`** (leave one). So **answer = total stones − number of groups**.

**Approach (Union-Find on rows and columns):** Treat each **row** and each **column** as a node (column `c` becomes node `maxRow + 1 + c`). A stone at `(r, c)` is an **edge** that unions row `r` with column `c`. Count the distinct components that contain at least one stone → **O(S α)** time.

**Intuition:** Two stones are in the same group exactly when their rows/columns are linked through a chain of stones. Modelling lines as nodes avoids comparing every pair of stones (O(S²)).

**Complexity:** Time O(S α(R + C)), Space O(R + C).

**Edge cases:** A single stone (0), all stones in one row (S − 1), no shared lines (0), a "staircase" of connected stones.

**Interview traps**
- **Offset the columns** so a row index and a column index don't collide.
- Count components of **stones**, not of all row/column nodes (unused lines would inflate the count).
- Union-find is the clean solution. DFS over stones works too but is O(S²) naively.
- The answer is `stones − components`, **not** `components`.

**How to explain:** "Stones that share a row or column belong to one group, and from each group of k stones I can remove k − 1. I find the groups by union-find, treating rows and columns as nodes and each stone as an edge joining its row to its column."
