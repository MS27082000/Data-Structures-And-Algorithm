# Jump Game II (LC 45)

**Problem:** `nums[i]` is the maximum jump length from `i`. The last index is always reachable. Return the **minimum number of jumps** to reach it.

**Brute force:** Recursion over all jump choices → exponential. **DP:** `dp[i]` = min jumps to reach `i` → O(n²).
**Optimal (greedy / implicit BFS):** Think in **levels**. Indices reachable with `k` jumps form a window. Track:
- `currentEnd`: the end of the current level,
- `farthest`: the farthest index reachable from anywhere in the current level.
When `i == currentEnd` the level is exhausted, so take one more jump and set `currentEnd = farthest`.

**Intuition:** It's BFS on an implicit graph, without a queue. Each "level" is one more jump.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Single element (0 jumps), `[1,1,1,1]` (3), a big first jump (`[10,1,1,1,1]` → 1), two elements.

**Interview traps**
- The loop runs to `n - 2`, **not** `n - 1`. Otherwise you count an extra jump when `currentEnd` equals the last index.
- Increment `jumps` only when you **reach the end of the current window**, not at every index.
- Know the progression: recursion → DP O(n²) → greedy O(n).
- Don't confuse it with Jump Game I (reachability only).

**How to explain:** "I expand in layers: everything reachable in k jumps is a window. While scanning the window I track the farthest index reachable. When I reach the window's end I must jump once more, and the new window ends at that farthest index."
