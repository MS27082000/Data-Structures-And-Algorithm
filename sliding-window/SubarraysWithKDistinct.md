# Subarrays with K Different Integers (LC 992)

**Problem:** Count subarrays that contain **exactly `k` distinct integers**.

**Brute force:** All subarrays with a set → O(n²).
**Optimal:** `exactly(k) = atMost(k) − atMost(k − 1)`. `atMost(k)` uses a sliding window with a frequency array/map: expand `right`, shrink while `distinct > k`, add `right − left + 1` → O(n).

**Why not a direct window:** For "exactly k", shrinking the window can **break** validity and then re-expanding is not monotonic, so a single pass can't capture all windows. "At most k" is monotonic.

**Intuition:** `atMost(k)` counts windows with 1..k distinct values. `atMost(k−1)` counts those with 1..k−1. The difference is exactly those with k distinct.

**Complexity:** Time O(n), Space O(n) (or O(k) with a map).

**Edge cases:** `k` larger than the number of distinct values (0), `k = 1` (runs of equal values: `[1,1,1]` → 6), all distinct, `k = 0`.

**Interview traps**
- Same technique as [Count Number of Substrings](../strings/CountSubstringsWithKDistinct.md) (exactly K distinct characters) and Binary Subarrays With Sum. Show that you see the pattern.
- Update `distinct` only when a count goes 0 ↔ 1.
- Values are in `1..n`, so a plain `int[n + 1]` is faster than a HashMap.
- A single-pass "prefix of valid left boundaries" solution exists but is harder to explain. Mention it only if asked.

**How to explain:** "Exactly K is awkward, but at most K is easy with a sliding window. So I count windows with at most K distinct and subtract those with at most K−1; what's left has exactly K."
