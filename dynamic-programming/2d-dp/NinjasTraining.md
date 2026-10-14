# Ninja's Training (2D DP)

**Problem:** `n` days, 3 activities per day with a merit point each. The same activity cannot be done on two consecutive days. Maximise the total points.

**Intuition:** State `f(day, last)` = best points from `day` to the end if yesterday's activity was `last` (3 means "none yet"). Try every activity except `last`: `f(day, last) = max over a != last of points[day][a] + f(day+1, a)`.

**Brute force:** Recursion over all choices, O(3^n).
**Optimised:** Bottom-up with a 4-entry row per day: O(n * 4 * 3) time, O(1) extra space (rolling array).

**Edge cases:** n = 1 (best single activity). Equal points everywhere. Large n -> use bottom-up to avoid recursion depth.

**Interview traps**
- The extra "no previous activity" state for day 0.
- The state must contain the **last choice** - day alone is not enough.

**How to explain:** "The only thing that limits today's choice is yesterday's activity, so my state is (day, last activity). I try the other two and take the maximum."
