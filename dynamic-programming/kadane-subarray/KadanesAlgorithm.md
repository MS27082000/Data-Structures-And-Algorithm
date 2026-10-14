# Kadane's Algorithm: Maximum Subarray (LC 53)

**Problem:** Find the contiguous subarray with the largest sum.

**Brute force:** Try every subarray, summing with a running total → O(n²). (O(n³) if you re-sum each time.)
**Optimal (Kadane):** One pass: `current = max(x, current + x)`, `best = max(best, current)` → O(n) time, O(1) space.

**Intuition:** At each element ask, "is it better to extend the previous subarray, or start fresh here?" A negative running sum only drags you down, so drop it.

**DP view:** `dp[i]` = best sum of a subarray **ending at i**. `dp[i] = max(a[i], dp[i-1] + a[i])`. Only the previous value is needed, so O(1) space.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** **All negative** (answer is the largest single element), a single element, zeros, the whole array.

**Interview traps**
- Initialise with `nums[0]`, **not 0**. Starting `best = 0` returns 0 for all-negative arrays, which is wrong.
- Know how to return the **subarray indices**: record `start` whenever you restart (see `maxSubArrayWithRange`).
- Follow-up: circular array (max subarray in a circle) and the divide-and-conquer O(n log n) solution.

**How to explain:** "Track the best sum ending at the current element. Either extend the previous run or start a new one, whichever is larger, and keep the best seen overall."
