# Minimum Window Subsequence (LC 727)

**Problem:** Given `s1` and `s2`, find the smallest contiguous substring of `s1` in which `s2` appears as a **subsequence** (characters in order, gaps allowed). Return `""` if none; if several, the leftmost.

**Brute force:** Check every substring for the subsequence → O(n² · m).
**DP:** `dp[i][j]` = start of the best window ending at `i` matching `s2[0..j]` → O(n·m) time and space.
**Optimal-space two-pass (this solution):**
1. **Forward:** scan `s1` matching `s2`'s characters greedily until all `m` match; this fixes the window's **end**.
2. **Backward:** from that end walk back, matching `s2` from its last character, to find the **latest start**, which is the tightest window.
3. Record it, then continue scanning from `start + 1`.

**Intuition:** The forward scan finds *a* valid end; the backward scan removes the slack on the left. Restarting at `start + 1` lets the next window overlap, so a shorter one isn't missed.

**Complexity:** Time O(n · m) worst case, Space O(1).

**Edge cases:** `s2` longer than `s1`, a character of `s2` missing from `s1` (`""`), order wrong (`"abc"` / `"cba"` → `""`), several equal-length windows (leftmost).

**Interview traps**
- This is a **subsequence**, not a set of characters. Order matters. Plain Minimum Window Substring doesn't apply.
- The **backward pass is essential**. The forward pass alone gives a valid but not tightest start.
- Resume at `start + 1`, **not** after `end`, or you skip overlapping candidates.
- Mention the DP as the standard alternative.

**How to explain:** "I find where s2 can first be fully matched as a subsequence, then walk backwards from that end to find the tightest start. I record that window and restart just after its start."
