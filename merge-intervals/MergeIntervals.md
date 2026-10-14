# Merge Intervals (LC 56)

**Problem:** Given intervals `[start, end]`, merge all overlapping ones and return the non-overlapping result.

**Brute force:** Compare every pair repeatedly and merge until nothing changes → O(n²) or worse.
**Optimal:** **Sort by start**, then sweep: keep a `current` interval. If the next one starts at or before `current.end`, they overlap, so set `current.end = max(current.end, next.end)`. Otherwise output `current` and start a new one → O(n log n).

**Intuition:** After sorting by start time, any interval that overlaps `current` must come immediately after it, so one pass is enough.

**Complexity:** Time O(n log n) (the sort), Space O(n) for the output.

**Edge cases:** Empty input, one interval, touching intervals (`[1,4]`, `[4,5]` merge), a fully contained interval (`[1,4]`, `[2,3]`), unsorted input, identical intervals.

**Interview traps**
- Use **`max`** for the new end. The next interval may be completely inside the current one.
- Overlap test is `next.start <= current.end` (use `<=` since touching counts, unless the problem says otherwise).
- **Sort first.** Without sorting the sweep is wrong.
- Don't mutate the caller's array unless allowed (copy before sorting).
- This is the base for Insert Interval, Meeting Rooms, and Employee Free Time.

**How to explain:** "Sort by start time, then walk through the intervals keeping the one I'm building. If the next starts before mine ends I extend my end to the larger of the two ends, otherwise I finalise mine and start a new one."
