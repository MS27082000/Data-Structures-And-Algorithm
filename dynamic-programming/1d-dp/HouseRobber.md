# House Robber I and II (LC 198, LC 213)

**Problem:** Houses with money; you cannot rob two adjacent houses. (II: houses are in a **circle**, so first and last are adjacent.) Maximise the loot.

**Intuition:** I is exactly Maximum Sum of Non-Adjacent Elements. For II, the first and last cannot both be robbed - so the answer is the better of two linear runs: **houses 0..n-2** or **houses 1..n-1**.

**Brute force:** Try all subsets, O(2^n).
**Optimised:** I - O(n) time, O(1) space. II - two linear runs, still O(n) time, O(1) space.

**Edge cases:** n = 1 (circular: return that house, do not run two empty ranges). n = 2 (circular: max of the two).

**Interview traps**
- The n = 1 case in the circular version - both ranges would be empty.
- Do not try to "remember if the first was used"; two separate runs are simpler and correct.

**How to explain:** "Linear case is take-or-skip DP. In a circle, either the first or the last house is left out, so I run the linear DP on both remaining ranges and take the larger."
