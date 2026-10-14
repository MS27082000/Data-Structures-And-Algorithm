# Lemonade Change (LC 860)

**Problem:** Lemonade costs $5. Customers (in order) pay with $5, $10 or $20 bills. You start with no change. Can you give correct change to every customer?

**Brute force:** Try every way of making change for a $20 (backtracking) → exponential in theory.
**Optimal (greedy):** Keep counts of `$5` and `$10` bills (`$20` bills are never used for change):
- `$5`: take it.
- `$10`: give one `$5`.
- `$20` (change = $15): **prefer `$10 + $5`**, otherwise `3 × $5`.

**Why prefer `$10 + $5`:** `$5` bills are the most flexible. They are needed for change on both `$10` and `$20`. A `$10` bill is only useful for `$20` change. So spend the less flexible bill first.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** First customer pays `$10` or `$20` (false), no customers (true), many `$20`s in a row, running out of `$5`s.

**Interview traps**
- **Order matters:** try `10 + 5` before `5 + 5 + 5`. The other order can fail on valid inputs.
- Don't track `$20` bills; they can't be given as change.
- Return `false` immediately when change can't be made.

**How to explain:** "I track my 5s and 10s. For a 20 I give back a 10 and a 5 if I can, because 5s are more versatile, otherwise three 5s."
