# Lower Bound

**Problem:** In a sorted array return the smallest index `i` with `a[i] >= x`. If none, return `n`.

**Brute force:** Scan until `a[i] >= x` → O(n).
**Optimal:** Binary search for the **first index where the condition is true** → O(log n).

**Approach (key template):** `low = 0, high = n` (n is a valid answer). While `low < high`: if `a[mid] >= x` → `high = mid` (mid may be the answer), else `low = mid + 1`. Return `low`.

**Intuition:** The condition `a[i] >= x` looks like `false false false true true true`. We are finding the first `true`.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** All smaller than x (→ n), all larger (→ 0), duplicates (returns the first of them), empty array.

**Interview traps**
- Set `high = n`, not `n - 1`, or "insert at the end" can't be returned.
- Use `high = mid` (not `mid - 1`) in this template, and `low < high` as the loop condition.
- It equals Java's `Collections.binarySearch` insertion point and C++ `lower_bound`.
- **This one template solves ~half the binary search questions.** Learn it well.

**How to explain:** "Find the first position where the value is at least x. Everything left of it is smaller, so I keep narrowing to the first true."
