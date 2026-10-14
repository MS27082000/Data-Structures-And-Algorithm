# Non-overlapping Intervals (LC 435)

**Problem:** Return the **minimum number of intervals to remove** so the remaining intervals don't overlap. (Touching intervals like `[1,2]`, `[2,3]` don't overlap.)

**Brute force:** Try all subsets → exponential. **DP:** longest chain of compatible intervals → O(n²).
**Optimal (greedy = activity selection):** **Sort by END time.** Keep an interval if it starts at or after the last kept interval's end; otherwise drop it. Answer = `n − kept` → O(n log n).

**Why sort by end:** Choosing the interval that finishes earliest leaves the most room for the rest. Sorting by start can pick a huge early interval that blocks many small ones.

**Complexity:** Time O(n log n), Space O(1) extra.

**Edge cases:** Empty input, all identical intervals (`n − 1` removals), touching intervals (0 removals), one interval containing several others.

**Interview traps**
- Sort by **end**, not start. This is the key insight.
- Touching is **not** overlapping: use `start >= lastEnd`.
- Answer is the number **removed** (`n − kept`), not kept.
- Same algorithm as **N Meetings in One Room** (maximum non-overlapping set).
- Alternative when sorting by start: on overlap, remove the interval with the **larger end** (greedy again).

**How to explain:** "It's activity selection: find the largest set of non-overlapping intervals by always taking the one that ends first. The intervals I can't keep are the ones to remove."
