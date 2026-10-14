# Remove Duplicates from Sorted Array (LC 26)

**Problem:** Remove duplicates **in-place** from a sorted array, return the count `k` of unique elements (first `k` slots hold them).

**Brute force:** Copy to a LinkedHashSet/new list and write back → O(n) time but O(n) space (violates in-place).

**Approach:** Same-direction pointers. `slow` marks the last unique element; `fast` scans. If `nums[fast] != nums[slow]`, do `slow++` and `nums[slow] = nums[fast]`. Return `slow + 1`.

**Intuition:** Sorted means duplicates sit together, so comparing with the last kept value is enough. `slow` is the write position and `fast` is the read position.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty array, one element, all identical, all unique.

**Interview traps**
- Return the **length**, not the array. Contents past `k` don't matter.
- Compare with `nums[slow]`, not `nums[fast-1]` (both work here, but `slow` generalises to "allow at most 2 duplicates", LC 80).
- Guard the empty array.

**How to explain:** "Reader/writer pointers. The writer only advances when the reader finds a new value, so unique values get packed at the front in place."
