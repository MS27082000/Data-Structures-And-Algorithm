# Longest Subarray with Sum K

**Problem:** Length of the longest subarray whose sum is exactly `k`. The array can contain negatives and zeros.

**Brute force:** All subarrays with a running sum → O(n²).
**Optimal (any values):** **Prefix sum + HashMap** (prefix → first index) → O(n) time, O(n) space.
**Optimal (positives only):** Sliding window / two pointers → O(n) time, **O(1) space**.

**Approach:** At index `i` with prefix sum `P`, a subarray ending at `i` has sum `k` iff an earlier prefix equals `P - k`. If it first appeared at index `j`, the length is `i - j`. Seed the map with `{0 → -1}` for subarrays starting at index 0.

**Intuition:** `sum(a[j+1..i]) = P[i] - P[j]`. So "sum equals k" becomes "`P[j] = P[i] - k`", which is a hash lookup.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** No such subarray (0), the whole array, negatives and zeros, `k = 0`, a single element equal to `k`.

**Interview traps**
- Store the **first** occurrence only (`putIfAbsent`). Overwriting shortens the answer.
- Seed `{0 → -1}`. Without it, subarrays starting at index 0 are missed.
- **Sliding window fails with negatives**, since the sum isn't monotonic. This is the #1 follow-up. Use it only for non-negative input.
- Use `long` for the prefix if values are large.

**How to explain:** "Track prefix sums in a map with their earliest index. At each position I check whether `prefix - k` was seen, which gives a subarray summing to k, and keep the longest."
