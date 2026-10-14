# Missing Number (LC 268)

**Problem:** Array of `n` distinct numbers taken from `0..n`; find the one missing.

**Brute force:** For each value in 0..n, linear search → O(n²). Or sort and find the gap → O(n log n).
**Better:** HashSet / visited array → O(n) time, O(n) space.
**Optimal:** Sum formula `n(n+1)/2 - sum`, or XOR of all indices and values → O(n) time, O(1) space.

**Intuition (XOR):** `a ^ a = 0`. XOR every index 0..n with every element, and everything cancels except the missing number.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `[0]` → 1, `[1]` → 0, missing is 0 or n.

**Interview traps**
- The sum approach can **overflow** for large `n`. Use `long` or XOR.
- Check the value range: the numbers are 0..n here, but Striver's version may use 1..n. Adjust the formula.
- Follow-up: two missing numbers or one missing plus one repeating (see Find Repeating and Missing).

**How to explain:** "XOR all indices 0..n and all elements. Pairs cancel, leaving the missing number. No extra space, no overflow."
