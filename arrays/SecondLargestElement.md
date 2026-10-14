# Second Largest Element

**Problem:** Return the second largest **distinct** value, or -1 if it doesn't exist.

**Brute force:** Sort and take the second last unequal value → O(n log n).
**Better:** Two passes: find the max, then the largest value `< max` → O(n), two passes.
**Optimal:** One pass tracking `largest` and `second`.

**Steps:** For each `x`: if `x > largest` → `second = largest; largest = x`. Else if `x < largest && x > second` → `second = x`.

**Intuition:** `second` only changes when something beats it without matching `largest`, so duplicates of the max are ignored automatically.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** All elements equal (→ -1), size 1, duplicates of the max (`[10, 5, 10]` → 5), negatives, `Integer.MIN_VALUE` in the input.

**Interview traps**
- Using `x >= second` or `x != second` wrongly allows duplicates of the max to become the second.
- Initialising with `Integer.MIN_VALUE` can clash with real values. Use `long` or an index sentinel.
- Decide with the interviewer whether "second largest" means distinct.

**How to explain:** "Single pass with two variables. When a new max arrives, the old max becomes second. Otherwise a value strictly between second and max replaces second."
