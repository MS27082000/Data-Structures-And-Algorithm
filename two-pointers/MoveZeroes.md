# Move Zeroes (LC 283)

**Problem:** Move all 0s to the end in-place, keeping the relative order of non-zeros.

**Brute force:** Copy non-zeros to a new array, then pad zeros → O(n) time, O(n) space.
**Middle option:** Compact non-zeros in place, then fill the rest with 0 (two passes).

**Approach:** `slow` = next position for a non-zero. For each `fast`, if `nums[fast] != 0`, swap with `nums[slow]` and `slow++`.

**Intuition:** Everything before `slow` is non-zero (settled). Swapping drops the zero behind the pointer automatically, so one pass does it all.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** All zeros, no zeros, single element, zeros already at the end.

**Interview traps**
- Order of non-zeros **must be preserved**. A two-ends swap approach breaks this.
- When no zeros are present, the swap is `slow == fast` (a self-swap). It's harmless, but can be skipped if `slow != fast` to reduce writes (a common follow-up: "minimise writes").
- Don't use extra space.

**How to explain:** "Same reader/writer idea as removing duplicates. The writer pointer gathers non-zeros at the front by swapping, and zeros end up behind it."
