# Linear Search

**Problem:** Find the index of `target` in an array, or -1.

**Brute force = optimal for unsorted data:** Scan left to right → O(n) time, O(1) space.
**If sorted:** use Binary Search → O(log n).

**Intuition:** With no order information, every element may be the answer, so you must check each one.

**Edge cases:** Empty array, target absent, duplicates (return the first index), target at the first or last position.

**Interview traps**
- Say that binary search needs a sorted array. Linear search is the right call otherwise.
- Return the first occurrence unless asked for all.

**How to explain:** "Check each element in turn and return as soon as it matches. O(n), no extra space."
