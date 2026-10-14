# Floor and Ceil in a Sorted Array

**Problem:** For a value `x`: **floor** = largest element `<= x`, **ceil** = smallest element `>= x`. Return -1 for a missing one.

**Brute force:** Scan the array tracking both → O(n).
**Optimal:** Binary search, recording candidates as you narrow → O(log n).

**Approach:** If `a[mid] == x` → both are `x`. If `a[mid] < x` → `mid` is a floor candidate, go right. Else `mid` is a ceil candidate, go left.

**Intuition:** Every time you move right the element you leave behind is a floor candidate, and every time you move left the element is a ceil candidate. The last recorded candidates are the best.

**Alternative:** `ceil = a[lowerBound(x)]`, `floor = a[upperBound(x) - 1]` (guard the bounds).

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** `x` smaller than all (floor = -1), larger than all (ceil = -1), `x` present, duplicates.

**Interview traps**
- Return `-1` only when no such element exists. Don't confuse "-1" with a valid negative value, so ask or use an index/sentinel if negatives are possible.
- Equal case: floor and ceil are both `x`.

**How to explain:** "While narrowing, remember the last element I stepped over on each side. Those are the closest smaller-or-equal and larger-or-equal values."
