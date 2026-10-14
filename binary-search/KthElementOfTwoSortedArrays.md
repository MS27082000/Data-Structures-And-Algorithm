# Kth Element of Two Sorted Arrays

**Problem:** Two sorted arrays; find the `k`-th smallest element (1-indexed) of the merged order.

**Brute force:** Merge and pick index `k-1` → O(m + n).
**Better:** Two pointers advancing `k` steps → O(k), O(1) space.
**Optimal:** **Binary search on the partition**, the same idea as the median → O(log min(m, n)).

**Approach:** Take `i` elements from `a` and `j = k - i` from `b` as the left part (size exactly `k`). Valid when `a[i-1] <= b[j]` and `b[j-1] <= a[i]`; the answer is `max(a[i-1], b[j-1])`. Otherwise shift `i` (too many from `a` → `high = i-1`; too few → `low = i+1`).

**Range for `i`:** `low = max(0, k - n)` (b can't supply more than n), `high = min(k, m)`.

**Intuition:** The median problem is just this with `k = (m+n)/2`. The k-th element is the largest value in the combined left part of size `k`.

**Complexity:** Time O(log min(m, n)), Space O(1).

**Edge cases:** One array empty, `k = 1`, `k = m + n`, `k` larger than one array's length.

**Interview traps**
- The **bounds of `i`** (`max(0, k-n)` to `min(k, m)`) are the common bug. Without them `j` goes negative or past `n`.
- Use ±∞ sentinels at the edges.
- Binary search the smaller array.

**How to explain:** "Pick i from the first array and k-i from the second so that together they form the k smallest. I binary search i until the cross-conditions hold; the k-th element is the max of the two left boundaries."
