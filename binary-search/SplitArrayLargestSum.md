# Split Array Largest Sum (LC 410)

**Problem:** Split an array into `k` non-empty **contiguous** subarrays so that the **largest** subarray sum is minimised.

**Brute force:** Try all splits → exponential. **DP:** `dp[i][j]` = best for the first `i` elements in `j` parts → O(n²·k).
**Optimal:** **Binary search on the largest sum** in `[max(a), sum(a)]` → O(n log sum).

**Feasibility check:** Greedily fill the current subarray until adding the next element would exceed `limit`, then start a new one. Feasible if parts `<= k`.

**Intuition:** A larger limit never needs more parts. "Minimise the maximum" is the classic signal for binary search on the answer.

**Complexity:** Time O(n log sum), Space O(1).

**Edge cases:** `k = 1` (sum), `k = n` (max element), a single element, zeros.

**Interview traps**
- If the greedy uses *fewer* than `k` parts, that's fine. You can split further without increasing the max (elements are non-negative).
- Low bound is `max(a)`, high bound `sum(a)`.
- **Identical** to Painter's Partition and Book Allocation. Say that in the interview.
- The DP solution is a valid fallback, but the binary search is expected.

**How to explain:** "I binary search the largest allowed subarray sum. For a limit I greedily cut the array whenever the running sum would exceed it, and check that I need at most k pieces."
