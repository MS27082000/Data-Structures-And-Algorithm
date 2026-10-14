# Path With Minimum Effort (LC 1631)

**Problem:** A grid of heights. The **effort** of a path is the **maximum absolute height difference between two consecutive cells** on it. Find the path from the top-left to the bottom-right with the **minimum effort**.

**Approach:** Dijkstra where the "distance" is the **maximum edge so far**, not the sum. Relax with `newEffort = max(effort[u], |h[v] − h[u]|)`; update if smaller → **O(R·C · log(R·C))**.
**Alternatives:** Binary search on the answer + BFS/DFS feasibility check; or Union-Find over edges sorted by difference.

**Intuition:** It is a **minimax path** problem. Dijkstra's greedy argument still holds because extending a path can never decrease its maximum.

**Complexity:** Time O(R·C log(R·C)), Space O(R·C).

**Edge cases:** A single cell (0), a flat grid (0), a single row or column, big height jumps forcing a detour.

**Interview traps**
- The cost combines with **`max`, not `+`**. Don't sum the differences.
- It's a shortest path in the sense of *bottleneck*. Recognise the pattern: "minimise the maximum".
- Stop as soon as the destination is **popped** (its effort is final).
- Same pattern as [Swim in Rising Water](SwimInRisingWater.md).

**How to explain:** "I run Dijkstra but the cost of a path is its largest step, so relaxing an edge gives the max of the current effort and that edge's height difference. The first time I pop the bottom-right cell I have the minimum effort."
