# Triangle (LC 120)

**Problem:** From the apex move to an adjacent number on the next row (index i or i+1). Minimum path sum to the bottom.

**Intuition:** Go **bottom-up**: each cell = its value + the smaller of the two cells below. The top cell then holds the answer - no edge cases for ending anywhere.

**Brute force:** Recursion, O(2^n).
**Optimised:** O(n^2) time (n rows), O(n) space by reusing one array.

**Edge cases:** One row. Negative numbers (so greedy fails).

**Interview traps**
- Top-down needs "min of last row" at the end; bottom-up gives the answer in `dp[0]`.
- Greedy "pick the smaller child" is wrong.

**How to explain:** "I start from the last row and fold upward, each cell adding the cheaper child. The apex is the answer."
