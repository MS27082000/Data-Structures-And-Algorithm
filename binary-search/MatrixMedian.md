# Median of a Row-wise Sorted Matrix

**Problem:** An `m x n` matrix (with `m·n` odd) where each row is sorted. Find the median of all elements without flattening and sorting.

**Brute force:** Flatten and sort → O(m·n log(m·n)), O(m·n) space.
**Optimal:** **Binary search on the value** in `[min, max]`.

**Approach:** The median is the smallest value `x` such that at least `(m·n + 1)/2` elements are `<= x`. For a candidate `mid`, count elements `<= mid` in each row using **upper bound** (binary search per row). If `count >= need` → `high = mid`, else `low = mid + 1`.

**Intuition:** The count of elements `<= x` is non-decreasing in `x`, so it's binary-searchable. The first `x` that reaches the median rank is the median.

**Complexity:** Time O(log(max - min) · m · log n), roughly 32·m·log n. Space O(1).

**Edge cases:** Single row, single element, negatives, repeated values, all equal.

**Interview traps**
- Search the **value range**, not indices (rows aren't globally sorted).
- Median rank is `(m·n + 1) / 2`. It requires `m·n` odd. Ask about the even case.
- Use upper bound (`<= mid`), not lower bound, to count.
- Also known as the "Kth smallest in a sorted matrix" family. The same method solves it with a different `need`.

**How to explain:** "I binary search the answer value. For each candidate I count how many elements are at most that value using a binary search on every row, and I keep the smallest value that has at least half the elements below it."
