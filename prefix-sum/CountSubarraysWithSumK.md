# Count Subarrays with Sum K (LC 560)

**Problem:** Count contiguous subarrays whose sum equals `k`. Negatives and zeros are allowed.

**Brute force:** All subarrays → O(n²).
**Optimal:** Prefix sum + HashMap of **counts** → O(n) time, O(n) space.

**Approach:** For each element update the prefix `P`. The number of subarrays ending here with sum k equals how many earlier prefixes equal `P - k`. Add that count to the answer, then record `P` in the map. Seed `{0 → 1}` for the empty prefix.

**Intuition:** Same identity as before, `P[i] - P[j] = k`. Since we need *all* matches (not just the longest), we store how many times each prefix has occurred.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** All zeros with `k = 0` (`[0,0,0]` → 6), negatives, no match, `k` equals the whole array's sum.

**Interview traps**
- **Sliding window doesn't work** because of negatives.
- Look up `P - k` **before** inserting `P`. Otherwise with `k = 0` you count the empty subarray.
- Seed `{0 → 1}`, or subarrays starting at index 0 are missed.
- This answer counts, so the map stores **counts**, not indices (unlike the "longest" version).

**How to explain:** "Keep a map of how often each prefix sum has occurred. At each position, the number of earlier prefixes equal to `prefix - k` is the number of valid subarrays ending here."
