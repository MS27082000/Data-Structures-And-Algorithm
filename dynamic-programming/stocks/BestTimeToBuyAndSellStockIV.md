# Best Time to Buy and Sell Stock IV (LC 188)

**Problem:** At most **k** transactions.

**Intuition:** Generalise III: arrays `buy[t]`, `sell[t]` for t = 1..k. `buy[t] = max(buy[t], sell[t-1] - p)`, `sell[t] = max(sell[t], buy[t] + p)`.
**Shortcut:** If `k >= n/2` the limit never binds -> same as unlimited transactions (greedy). This avoids huge arrays and memory limits.

**Brute force:** Recursion on (day, holding, k left).
**Optimised:** O(n * k) time, O(k) space.

**Edge cases:** k = 0, n < 2, huge k.

**Interview traps**
- Handle the large-k case first or you will time out / run out of memory.
- Initialise `buy[]` to a very negative value.

**How to explain:** "It is the two-transaction DP with k layers. When k is at least n/2 the limit is irrelevant, so I just sum all rises."
