# Best Time to Buy and Sell Stock II (LC 122)

**Problem:** Unlimited transactions; hold at most one share at a time.

**Intuition (greedy):** Add every positive day-to-day rise. A long rising trade equals the sum of its daily gains.
**Intuition (DP):** Two states per day: `hold` and `notHold`. `notHold = max(notHold, hold + p)`, `hold = max(hold, notHold - p)`. This is the template for all the other stock problems.

**Brute force:** Recursion over buy/sell/skip, exponential.
**Optimised:** O(n) time, O(1) space.

**Edge cases:** Strictly falling -> 0. Strictly rising -> last - first.

**Interview traps**
- You cannot buy again while holding a share (one at a time), but buying and selling on the same day is harmless.
- Explain why greedy is valid, then show the DP to prove you know the general template.

**How to explain:** "Since I can trade as often as I like, I collect every upward step. Equivalently, a hold/not-hold DP."
