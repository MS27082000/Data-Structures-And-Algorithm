# Making A Large Island (LC 827)

**Problem:** A binary grid. You may change **at most one `0` to `1`**. Return the size of the **largest island** you can get.

**Brute force:** For every `0`, flip it and run DFS to measure the island → O((n²)²).
**Optimal (Union-Find with sizes):**
1. Union all adjacent land cells; keep **`size[root]`**.
2. For every `0` cell, look at its 4 neighbours and collect the **distinct roots** of neighbouring islands (use a `Set`). Flipping it yields **`1 + sum of those islands' sizes`**.
3. The answer is the maximum over all `0` cells, and over existing island sizes. If the grid has **no 0**, the answer is `n × n`.
→ **O(n² α)**.

**Intuition:** Flipping a water cell merges all distinct islands touching it plus the cell itself. Precomputing island sizes turns each candidate into a constant-time sum.

**Complexity:** Time O(n² α(n²)), Space O(n²).

**Edge cases:** No zeros (`n²`), no ones (answer 1), a zero touching the **same island twice** (count it once), a zero surrounded by four separate islands.

**Interview traps**
- **Deduplicate neighbour roots.** One island can touch the water cell on two sides.
- The answer must also consider **not flipping** anything (when there is no zero) → `n²`.
- Compute sizes **before** evaluating any flip, and don't mutate the grid while evaluating.
- DFS labelling islands with ids + a size map is an equally valid alternative.

**How to explain:** "I merge the existing land into islands and record their sizes with union-find. For each water cell I add up the sizes of the distinct islands around it plus one, take the maximum, and handle the no-water case separately."
