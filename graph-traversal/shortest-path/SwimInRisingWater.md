# Swim in Rising Water (LC 778)

**Problem:** An `n × n` grid of elevations. At time `t` the water level is `t`; you can move to a 4-neighbouring cell only if its elevation is `≤ t` (you may swim any distance instantly). Find the **least time** needed to go from `(0, 0)` to `(n−1, n−1)`.

**Approach (Dijkstra, minimax path):** The time needed for a path is the **highest elevation on it**. Run Dijkstra with `cost(next) = max(cost so far, grid[next])` and a min-heap → **O(n² log n)**.
**Alternatives:** Binary search on `t` + BFS reachability; Union-Find adding cells in increasing elevation until `(0,0)` and `(n−1,n−1)` connect.

**Intuition:** You must wait until the water covers the **tallest** cell on your route, so minimise the maximum. Dijkstra's greedy works for any monotone path cost such as `max`.

**Complexity:** Time O(n² log n), Space O(n²).

**Edge cases:** A 1×1 grid (its own elevation), the start cell higher than all others (answer ≥ start), values are a permutation of `0..n²−1`.

**Interview traps**
- The start cell's elevation counts: begin with `cost = grid[0][0]`.
- **`max`, not `+`**. Same pattern as [Path With Minimum Effort](PathWithMinimumEffort.md).
- Return when the destination is **popped**.
- Because the values are distinct, the Union-Find approach (sort cells, merge as the level rises) is a neat alternative.

**How to explain:** "The time for a path is the tallest cell on it, so I want the path minimising its maximum elevation. I run Dijkstra where moving to a neighbour costs the max of the current cost and that cell's height, and return the cost when I reach the bottom-right."
