# Merge Two Sorted Arrays Without Extra Space

**Problem:** Arrays `a` (size n) and `b` (size m), both sorted. Merge **in place** so that `a` holds the smallest n elements and `b` the largest m, each sorted.

**Brute force:** Merge into a third array and copy back → O(n+m) time, O(n+m) space (not allowed).
**Approach 1 (swap + sort):** `i = n-1` in `a`, `j = 0` in `b`. While `a[i] > b[j]`, swap and move both. Then sort both arrays → O((n+m) + n log n + m log m), O(1) space.
**Approach 2 (gap method, Shell sort idea):** `gap = ceil((n+m)/2)`. Compare elements `gap` apart across the virtual concatenation of `a` and `b`, swap if out of order, then `gap = ceil(gap/2)` until gap is 1 → O((n+m) log(n+m)), O(1) space.

**Intuition:**
- Approach 1: the largest of `a` and smallest of `b` are the only ones that can be on the wrong side. Swapping them moves the right elements across, and the final sorts fix the order inside each array.
- Approach 2: it is a gapped insertion sort. Once the gap reaches 1, everything is sorted.

**Edge cases:** Already in order (no swaps), all of `b` smaller than all of `a`, unequal sizes, duplicates.

**Interview traps**
- Handle three comparison cases in the gap method: `a` vs `a`, `a` vs `b`, `b` vs `b`. This is the usual bug.
- Gap update is `(gap + 1) / 2` (ceil), and stop **after** processing gap 1.
- This is different from LC 88, where `a` has spare space at its end and you merge from the back.

**How to explain:** "Swap the big end of `a` with the small end of `b` until nothing's out of place, then sort each. Or use the gap method, which is O((n+m) log(n+m)) with no extra space."
