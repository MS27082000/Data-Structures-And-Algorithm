# Insert Interval (LC 57)

**Problem:** A list of **sorted, non-overlapping** intervals and a new interval. Insert it and merge any overlaps. The result must stay sorted and non-overlapping.

**Brute force:** Add the new interval, sort everything, then run Merge Intervals → O(n log n).
**Optimal (one pass, O(n)):** The input is already sorted, so use three phases:
1. **Before:** copy intervals with `end < newStart` (entirely left of the new one).
2. **Overlapping:** while `interval.start <= newEnd`, merge: `newStart = min(...)`, `newEnd = max(...)`. Then add the merged interval.
3. **After:** copy the remaining intervals.

**Intuition:** All intervals that overlap the new one are consecutive. Everything before is untouched, everything after is untouched.

**Complexity:** Time O(n), Space O(n) for the output. (Binary search can locate the position in O(log n), but copying is still O(n).)

**Edge cases:** Empty list, new interval before all or after all, new interval swallowing everything, new interval inside one existing interval, touching intervals.

**Interview traps**
- Phase 1 condition is `intervals[i][1] < start` (strictly before). An interval that **touches** (`end == start`) must be merged.
- Phase 2 condition is `intervals[i][0] <= end`.
- Always add the merged interval **after** phase 2, even when nothing overlapped.
- Don't re-sort. The sorted input is the whole point of the O(n) solution.

**How to explain:** "Copy the intervals that end before the new one starts, merge every interval that overlaps it into one, add that, then copy the rest. Single pass because the input is sorted."
