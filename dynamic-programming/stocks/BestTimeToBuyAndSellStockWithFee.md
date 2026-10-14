# Best Time to Buy and Sell Stock with Transaction Fee (LC 714)

**Problem:** Unlimited transactions; a fee is paid per transaction.

**Intuition:** Stock II hold/cash DP, but selling costs the fee: `cash = max(cash, hold + p - fee)`, `hold = max(hold, cash - p)`.

**Brute force:** Recursion, exponential.
**Optimised:** O(n) time, O(1) space.

**Edge cases:** Fee larger than any gain -> 0. One day.

**Interview traps**
- Charge the fee once per transaction (on sell *or* buy, not both).
- Plain greedy "add every rise" fails because small rises do not cover the fee.

**How to explain:** "Same hold/cash states as the unlimited problem, but each sale subtracts the fee."
