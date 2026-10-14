# Leaders in an Array

**Problem:** An element is a leader if it is **greater than every element to its right**. Return all leaders (left-to-right order). The last element is always a leader.

**Brute force:** For each element, scan everything on the right → O(n²).
**Optimal:** Scan from the **right**, keep the max seen so far; if `a[i] > max` it is a leader → O(n).

**Intuition:** "Greater than everything on the right" is exactly "greater than the max of the right side", and scanning from the right gives you that max for free.

**Complexity:** Time O(n), Space O(1) extra (O(n) for the output).

**Edge cases:** Strictly decreasing (all leaders), strictly increasing (only the last), equal elements (`[7,7,7]` → `[7]`, because "strictly greater"), single element.

**Interview traps**
- The answer is collected right-to-left. **Reverse** it (or fill from the back) to get the original order.
- Strictly greater vs greater-or-equal changes the answer for duplicates. Clarify it.

**How to explain:** "Walk from the end, tracking the maximum so far. Anything bigger than that max is a leader."
