# Maximum Product Subarray (LC 152)

**Problem:** Find the contiguous subarray with the largest **product**.

**Brute force:** All subarrays with a running product → O(n²).
**Optimal (DP / Kadane variant):** Track the max **and min** product ending at each index. → O(n) time, O(1) space.
**Alternative:** Prefix and suffix products. Track the running product from the left and from the right, reset to 1 after a 0 → O(n), O(1).

**Intuition:** Unlike a sum, a negative number can flip the smallest (most negative) product into the largest. So keep both extremes, and when `x < 0` swap them before multiplying.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Zeros (reset the product), an even or odd count of negatives, a single negative (`[-3]`), all negatives (`[-1,-2,-9,-6]` → 108).

**Interview traps**
- Keeping only the max (like Kadane) fails: `[-2, 3, -4]` needs the min to become 24.
- Zero resets both max and min, which `max(x, ...)` / `min(x, ...)` handle for free.
- Watch for overflow only if the constraints allow it (LeetCode guarantees a 32-bit answer).

**How to explain:** "Same as Kadane but with products. I keep the largest and smallest product ending here, swapping them when I hit a negative, because a negative times the smallest can become the largest."
