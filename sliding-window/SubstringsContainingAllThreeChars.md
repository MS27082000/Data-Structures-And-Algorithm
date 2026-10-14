# Number of Substrings Containing All Three Characters (LC 1358)

**Problem:** `s` has only `a`, `b`, `c`. Count substrings that contain **at least one of each**.

**Brute force:** Check every substring → O(n²) or O(n³).
**Optimal (last seen):** Keep the last index of `a`, `b`, `c`. For each `right`, a valid substring ending at `right` can start anywhere from `0` up to `min(lastA, lastB, lastC)`, so add `min + 1` (it's `0` if some letter hasn't appeared, because `min = -1`) → O(n), O(1).
**Window version:** For each `left`, find the smallest `right` with all three present. Then every longer end also works: add `n − right`. Shrink and repeat.

**Intuition:** Once a window ending at `right` contains all three letters, **extending the start further left keeps it valid**. So you count all starts at or before the earliest of the three last positions.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Missing a letter (0), exactly `"abc"` (1), a long run of one letter, repeated cycles `"abcabc"` (10).

**Interview traps**
- Count **substrings ending at `right`**, not windows of minimal size.
- When a letter hasn't appeared, `last = -1` makes `min + 1 = 0` automatically.
- In the window version add `n − right` (all ends from `right` to `n−1`), then shrink.
- Same monotonic idea as Count Subarrays problems. Superset windows of a valid window stay valid.

**How to explain:** "For each end position, the substrings that contain all three letters start at or before the leftmost of the three most recent occurrences, so I add that position plus one."
