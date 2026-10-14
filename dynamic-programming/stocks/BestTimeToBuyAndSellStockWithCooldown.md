# Best Time to Buy and Sell Stock with Cooldown (LC 309)

**Problem:** Unlimited transactions, but after selling you must skip one day before buying.

**Intuition:** Three states: `hold`, `sold` (just sold today), `rest` (free to buy).
`hold = max(hold, rest - p)`, `sold = hold + p`, `rest = max(rest, prevSold)`. Buying is only allowed from `rest`, which enforces the cooldown.

**Brute force:** Recursion on (day, holding) where selling jumps to day+2.
**Optimised:** O(n) time, O(1) space.

**Edge cases:** One or two days -> 0 (or a single trade). Falling prices.

**Interview traps**
- Use the **old** `sold` when updating `rest`.
- Answer is `max(sold, rest)`, never `hold`.
- In the recursive form: after selling, continue at `i + 2`.

**How to explain:** "The cooldown means I can only buy from a day that was not a sale day, so I keep a separate state for 'just sold'."
