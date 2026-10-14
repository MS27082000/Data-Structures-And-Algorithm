# Maximum Sum of Non-Adjacent Elements

**Problem:** Choose elements so no two chosen are neighbours. Maximise the sum.

**Intuition:** For each element: **take** it (value + best up to i-2) or **skip** it (best up to i-1). `f(i) = max(a[i] + f(i-2), f(i-1))`.

**Brute force:** Subsequences with the adjacency check, O(2^n).
**Optimised:** Tabulation with two variables, O(n) time, O(1) space.

**Edge cases:** Empty array -> 0. One element -> that element. All negative values: the answer is 0 if "choose nothing" is allowed - clarify. (Here values are non-negative.)

**Interview traps**
- Take = `a[i] + f(i-2)`, not `f(i-1)`.
- It is the base of House Robber and many "pick or skip" problems.

**How to explain:** "At each element I either take it and jump over its neighbour, or skip it. I keep the best of the last two positions."
