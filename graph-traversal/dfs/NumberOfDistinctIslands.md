# Number of Distinct Islands (LC 694)

**Problem:** Count islands by **shape**. Two islands are the same if one can be **translated** (moved, not rotated or reflected) onto the other.

**Brute force:** Store each island's cell coordinates normalised to the top-left cell and compare sets → works, O(R·C) with a lot of bookkeeping.
**Optimal (path signature):** During the DFS record the **sequence of moves** (D, U, R, L) from the island's starting cell, adding a **backtrack marker** (`b`) when the DFS returns. Islands with the same signature have the same shape. Add signatures to a `HashSet` and return its size → **O(R·C)**.

**Intuition:** The DFS order is deterministic, so identical shapes produce identical move strings regardless of where they sit on the grid.

**Complexity:** Time O(R·C), Space O(R·C).

**Edge cases:** No land, a single island, many one-cell islands (all identical → 1), L-shapes that are rotations of each other (**different**).

**Interview traps**
- **The backtrack marker is essential.** Without it two different shapes can produce the same move string (e.g. a tee versus a line).
- Record a move only when the cell is **valid**, and keep the same direction order everywhere.
- Mark visited on entry.
- Alternative: translate coordinates relative to the first cell and put sorted lists in a set.

**How to explain:** "I DFS each island and write down the path of moves from its first cell, including a marker when I backtrack. Identical shapes give identical strings, so the number of distinct strings is the answer."
