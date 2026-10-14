# Jump Game I (LC 55)

**Problem:** `nums[i]` is the maximum jump length from index `i`. Starting at index 0, can you reach the last index?

**Brute force:** Recursion trying every jump length from each index → exponential. With memoisation (DP) → O(n²).
**Optimal (greedy):** Keep `farthest`, the farthest index reachable so far. Scan left to right: if `i > farthest`, index `i` is unreachable → `false`. Otherwise update `farthest = max(farthest, i + nums[i])` → O(n), O(1).

**Intuition:** If you can reach index `i`, you can reach every index before it too, so the set of reachable indices is always a prefix `[0, farthest]`. You only need to track its right edge.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Single element (true), a `0` that blocks the path (`[3,2,1,0,4]`), `[0, 1]` (false), zeros that can be jumped over.

**Interview traps**
- Check `i > farthest` **before** using `nums[i]`.
- A zero is only a problem if you can't jump **over** it (`farthest` stops at it).
- Early exit when `farthest >= n - 1`.
- Follow-up: Jump Game II asks for the **minimum number** of jumps.

**How to explain:** "I keep the farthest index I can reach. If my position ever goes beyond it I'm stuck; otherwise I extend it using the jump at the current position."
