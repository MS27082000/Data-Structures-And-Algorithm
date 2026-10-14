# Painter's Partition

**Problem:** `n` boards with lengths, `k` painters. Each painter paints a **contiguous** group of boards. Minimise the time taken by the slowest painter (time = total length they paint).

**Brute force:** Try every way to split into k contiguous groups → exponential, or DP O(n²·k).
**Optimal:** **Binary search on the answer** (max load) in `[max(board), sum(boards)]` → O(n log sum).

**Feasibility check:** Greedily fill a painter until the next board would exceed `limit`, then start a new painter. If painters needed `<= k` → feasible.

**Intuition:** A larger limit never needs more painters, so it's monotonic. We want the smallest feasible limit ("minimise the maximum").

**Complexity:** Time O(n log sum), Space O(1).

**Edge cases:** `k = 1` (sum), `k = n` (max board), `k > n` (return -1 in some versions), a single board.

**Interview traps**
- Low bound is `max(board)`. Below it a board can't be painted at all.
- Contiguity matters. You cannot reorder boards (that would be a different problem).
- **Same problem** as Book Allocation, Split Array Largest Sum, and Capacity to Ship. Say "min of max" → binary search on the answer.
- Clarify what happens when `k > n`.

**How to explain:** "I binary search the maximum time per painter. For a given limit, I greedily assign boards to painters and count them; if the count fits in k, the limit works and I try lower."
