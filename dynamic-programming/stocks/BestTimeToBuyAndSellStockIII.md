# Best Time to Buy and Sell Stock III (LC 123)

**Problem:** At most **two** transactions.

**Intuition:** Four rolling values: `buy1, sell1, buy2, sell2`. The second buy is funded by the profit of the first sell: `buy2 = max(buy2, sell1 - p)`. A top-down version uses the state `(day, holding, transactionsLeft)`.

**Brute force:** Try every split point with one best trade on each side, O(n^2).
**Optimised:** O(n) time, O(1) space.

**Edge cases:** Falling prices -> 0. Only one useful trade -> sell2 equals sell1.

**Interview traps**
- Update the four values in order within the same day (buy1, sell1, buy2, sell2).
- Start buy values at a very negative number, not 0.
- A transaction = buy + sell; count it when you sell.

**How to explain:** "I track the best balance after each of the four actions. Each stage builds on the previous one, so one pass is enough."
