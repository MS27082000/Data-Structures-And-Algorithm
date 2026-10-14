# Upper Bound

**Problem:** In a sorted array return the smallest index `i` with `a[i] > x`. If none, return `n`.

**Brute force:** Linear scan → O(n).
**Optimal:** Same template as lower bound, with a strict `>` → O(log n).

**Approach:** `low = 0, high = n`. While `low < high`: `a[mid] > x` → `high = mid`, else `low = mid + 1`.

**Intuition:** The condition looks like `false … false true … true`, and we find the first true. Only the comparison differs from lower bound.

**Useful identities**
- Count of `x` = `upperBound(x) - lowerBound(x)`.
- Last occurrence of `x` = `upperBound(x) - 1`.
- Elements `<= x` = `upperBound(x)`.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** `x` larger than all (→ n), `x` smaller than all (→ 0), many duplicates of `x`, empty array.

**Interview traps**
- `>=` vs `>` is the *only* difference between lower and upper bound. Mixing them up gives off-by-duplicates answers.
- Return can equal `n`, so guard before indexing `a[result]`.

**How to explain:** "First index whose value is strictly greater than x. Everything before it is `<= x`."
