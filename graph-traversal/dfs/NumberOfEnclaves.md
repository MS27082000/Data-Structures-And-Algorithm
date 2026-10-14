# Number of Enclaves (LC 1020)

**Problem:** `1` = land, `0` = water. A move goes to a 4-neighbouring land cell or off the grid. Count the land cells from which you **cannot** walk off the boundary (enclaves).

**Brute force:** From every land cell run a search to see if it reaches the border → O((R·C)²).
**Optimal (reverse the question):** Start from **every border land cell** and flood-fill, marking everything reachable as "can escape" (sink it to `0`). Whatever land remains **cannot escape** → count it → **O(R·C)**.

**Intuition:** It is easier to find what can escape (spread inward from the border) than to test each cell separately. This "border-first" trick also solves Surrounded Regions.

**Complexity:** Time O(R·C), Space O(R·C) recursion worst case.

**Edge cases:** All land (0 enclaves, everything touches the border), no land, a single cell, an island fully inside a ring of water.

**Interview traps**
- Sink **all four borders**: top row, bottom row, left column, right column (corners are covered twice, which is harmless).
- Count the remaining `1`s **after** all border flood-fills finish.
- Don't count islands. It's the number of **cells**.

**How to explain:** "Instead of testing every land cell, I flood-fill from the land cells on the border, since those can escape and so can everything connected to them. The land cells left over are the enclaves."
