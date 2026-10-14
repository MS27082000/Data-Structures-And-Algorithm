# Find the Smallest Divisor Given a Threshold (LC 1283)

**Problem:** Choose a positive integer divisor `d`. Divide every element (rounding **up**) and sum the results. Find the smallest `d` with sum `<= threshold`.

**Brute force:** Try `d = 1, 2, 3…` → O(n · max).
**Optimal:** **Binary search on the answer** `d ∈ [1, max(a)]`. A bigger `d` gives a smaller sum, so feasibility is monotonic → O(n log max).

**Steps:** `sum = Σ ceil(a[i] / d)`. If `sum <= threshold` → feasible, try smaller (`high = mid`). Else `low = mid + 1`.

**Intuition:** This is the "minimise x such that condition(x) holds" template. Search the answer space, not the array.

**Complexity:** Time O(n log max), Space O(1).

**Edge cases:** `threshold == n` (answer is `max`), threshold large (answer 1), single element.

**Interview traps**
- `ceil(x / d)` as integer math is `(x + d - 1) / d`. Don't use floating-point division.
- Upper bound `max(a)` always works because every term becomes 1.
- Use `long` for the sum if sizes are large.
- Same template as Koko Eating Bananas.

**How to explain:** "The sum shrinks as the divisor grows, so I binary search the smallest divisor whose rounded-up sum fits under the threshold."
