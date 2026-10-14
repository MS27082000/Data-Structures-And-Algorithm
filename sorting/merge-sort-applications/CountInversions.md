# Count Inversions

**Problem:** Count pairs `(i, j)` with `i < j` and `a[i] > a[j]`. It measures how far the array is from sorted.

**Brute force:** Check all pairs → O(n²).
**Optimal:** **Merge sort.** While merging two sorted halves, if `a[j]` (right) is smaller than `a[i]` (left), then it is smaller than **all remaining left elements** `a[i..mid]`, so add `mid - i + 1` → O(n log n) time, O(n) space.
**Alternative:** Fenwick tree / BIT with coordinate compression → O(n log n).

**Intuition:** Inversions across the two halves can be counted in linear time because both halves are sorted. The inversions within each half are counted recursively.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** Sorted (0), reverse sorted (`n(n-1)/2`), duplicates (equal values are **not** inversions), empty array.

**Interview traps**
- Use `long` for the count. It reaches about n²/2.
- Use `<=` when taking from the left, so equal elements aren't counted.
- Count **during** the merge, and copy the array if the caller's array must stay unchanged.

**How to explain:** "Run merge sort. When an element from the right half is placed before the left's remaining elements, it forms an inversion with each of them, so I add how many are left."
