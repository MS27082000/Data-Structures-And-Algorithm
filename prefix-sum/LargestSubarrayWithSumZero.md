# Largest Subarray with Sum 0

**Problem:** Length of the longest subarray whose elements sum to 0.

**Brute force:** All subarrays → O(n²).
**Optimal:** Prefix sum + HashMap → O(n) time, O(n) space.

**Approach:** If the same prefix sum appears at indices `j < i`, the elements in `(j, i]` sum to 0. Store the **first** index of each prefix and take the max of `i - j`. Seed `{0 → -1}` so a prefix that is 0 itself counts (the subarray from index 0).

**Intuition:** This is "Longest Subarray with Sum K" with `k = 0`. Equal prefixes mean the stretch between them adds to zero.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** All zeros (whole array), no zero-sum subarray (0), a single 0, the full array summing to 0, empty array.

**Interview traps**
- Don't overwrite an existing prefix's index. Keeping the earliest maximises the length.
- Seed with `{0 → -1}`.
- Use `long` for prefix sums to avoid overflow.

**How to explain:** "If two prefix sums are equal, everything between them cancels to zero. I keep each prefix's first index and take the widest gap."
