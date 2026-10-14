# Count Number of Substrings (exactly K distinct characters)

> The Striver sheet shows only the title "Count Number of Substrings". I used the standard version of that problem: count substrings with **exactly K distinct characters**. If your version differs, tell me.

**Problem:** For a string of lowercase letters and an integer `K`, count substrings with exactly `K` distinct characters.

**Brute force:** Check all substrings with a set → O(n²) to O(n³).
**Optimal:** **Sliding window** with the identity `exactly(K) = atMost(K) - atMost(K-1)` → O(n) time, O(1) space.

**`atMost(K)`:** Move `right`; if distinct characters exceed `K`, shrink `left`. Every window ending at `right` is valid, and there are `right - left + 1` of them, so add that to the count.

**Intuition:** "Exactly K" is not monotonic, so you can't shrink a window directly. "At most K" is monotonic, and subtracting two at-most counts leaves the exact count.

**Complexity:** Time O(n), Space O(1) (26 counters).

**Edge cases:** `K = 0` (0), `K` larger than the number of distinct letters in the string (0), all characters the same (`"aaa"`, K=1 → 6), empty string.

**Interview traps**
- Add `right - left + 1` (all substrings ending at `right`), not 1.
- `atMost(K-1)` with `K = 1` means `atMost(0)`, which must return 0.
- Use `long` for counts (up to n²/2).
- The same trick solves **Subarrays with K Different Integers** (LC 992) and **Count Nice Subarrays**.

**How to explain:** "Counting windows with exactly K distinct is awkward, so I count those with at most K and subtract those with at most K-1, both with a standard sliding window."
