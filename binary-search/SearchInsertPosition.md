# Search Insert Position (LC 35)

**Problem:** Sorted array of distinct integers. Return the index of `target`, or the index where it should be inserted to keep order.

**Brute force:** Linear scan for the first element `>= target` → O(n).
**Optimal:** It is **exactly lower bound** → O(log n).

**Intuition:** The insert position is the first index whose value is `>= target`. If `target` exists, that index holds it.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Target smaller than all (0), larger than all (n), empty array, target already present.

**Interview traps**
- `high` must start at `n` so "insert at the end" is possible.
- Recognising it as lower bound is the point. Say so in the interview.

**How to explain:** "The insertion point is the first element not smaller than the target, which is lower bound."
