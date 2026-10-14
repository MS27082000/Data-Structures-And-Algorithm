# Find the Repeating and Missing Number

**Problem:** Array of size `n` contains numbers 1..n. One number appears twice (X), one is missing (Y). Find both.

**Brute force:** For each number 1..n, count occurrences → O(n²).
**Better:** Frequency/hash array → O(n) time, O(n) space.
**Optimal options (O(1) space):**
- **Math:** `S - n(n+1)/2 = X - Y` and `S2 - n(n+1)(2n+1)/6 = X² - Y²`. Then `X + Y = (X²-Y²)/(X-Y)`, so solve for X and Y.
- **XOR:** XOR everything to get `X ^ Y`, split into two groups using a set bit, then recover each.
- **Index marking:** negate `a[abs(x)-1]`. The index seen twice gives X, the positive index left gives Y (modifies the input).

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `[1,1]` → repeating 1, missing 2; repeating or missing at the boundaries (1 or n).

**Interview traps**
- Use **long** for the squares sum, which overflows `int` quickly.
- Index marking changes the input, so say so (restore it if required).
- Division by `X - Y`: it is never 0, because exactly one value repeats.

**How to explain:** "Two equations from the sum and sum of squares give X-Y and X+Y. Solve them. O(n) time, O(1) space."
