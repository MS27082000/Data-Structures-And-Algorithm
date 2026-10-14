# Kth Missing Positive Number (LC 1539)

**Problem:** A sorted array of distinct positive integers. Find the `k`-th positive integer that is **missing** from it.

**Brute force:** Walk through 1, 2, 3…, skipping array elements, counting the missing ones → O(n + k).
**Optimal:** Binary search in O(log n).

**Key fact:** The number of missing values before index `i` is `a[i] - (i + 1)` (the value minus the count it would have if nothing were missing).

**Approach:** Find the first index `low` where `missing(low) >= k`. Then the answer is `k + low` (the answer sits between `a[low-1]` and `a[low]`, and `low` array elements are smaller than it).

**Intuition:** `missing(i)` is non-decreasing in `i`, so it's binary-searchable. Shifting `k` by the number of array elements before the answer gives the value.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** `k` beyond the last element (`low = n`, answer `n + k`), all missing before `a[0]` (`[5,6,7]`, k=2 → 2), `[1,2,3,4]`, k=2 → 6.

**Interview traps**
- Answer is `low + k`, not `a[low] - something`. Derive it with an example.
- `high = n` (not `n - 1`), since the answer may lie after the last element.
- Mention the O(n) two-pointer / counting version first, then optimise.

**How to explain:** "At index i exactly `a[i] - i - 1` numbers are missing. I binary search the first index where at least k are missing; the kth missing number is then k plus the count of array elements before it."
