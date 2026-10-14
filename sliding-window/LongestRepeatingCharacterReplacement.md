# Longest Repeating Character Replacement (LC 424)

**Problem:** An uppercase string and an integer `k`. You may replace at most `k` characters with any letter. Return the length of the longest substring of one repeated letter.

**Brute force:** For each substring, count the most frequent letter and check `length − maxFreq ≤ k` → O(n²) to O(n³).
**Optimal:** Sliding window. A window is **valid** if `(window length − count of the most frequent letter) ≤ k`, i.e. the number of characters to replace is at most `k` → O(n), O(26).

**The maxFreq trick:** Maintain `maxFreq` as the highest count seen in **any** window so far and **never decrease it**. We only care about windows **larger** than the best so far, and a bigger window needs a bigger `maxFreq`. A stale `maxFreq` can't produce a longer wrong answer because the window never grows without a real increase in `maxFreq`. The window slides (by `if`, not `while`).

**Intuition:** In any window, keep the most frequent letter and replace the rest. The replacements needed are `length − maxFreq`.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `k = 0` (longest run), `k ≥ n − 1` (whole string), all distinct letters, single character.

**Interview traps**
- The safe version recomputes the max count each time (O(26 n)). Mention it first, then optimise.
- Explaining **why `maxFreq` need not shrink** is the common follow-up.
- Condition is `length − maxFreq > k` to shrink.
- Letters are `'A'..'Z'`, so a 26-array suffices.

**How to explain:** "A window is fine if the number of characters other than its most frequent letter is at most k. I expand right, and when the window needs more than k replacements I slide the left edge by one."
