# Rod Cutting

**Problem:** A rod of length n, with a price for each piece length. Cut to maximise total price.

**Intuition:** Unbounded knapsack: piece length = weight, price = value, capacity = n. `dp[len] = max(price[p-1] + dp[len - p])`.

**Brute force:** Recursion over the first cut, O(2^n).
**Optimised:** O(n^2) time, O(n) space.

**Edge cases:** n = 0 -> 0. Price list shorter than n (limit p). Not cutting is allowed (a piece of full length).

**Interview traps**
- A longer piece is not always more valuable per unit - that is why DP is needed.
- Recognise the mapping to unbounded knapsack.

**How to explain:** "The first piece I cut has some length p; the rest is the same problem with a smaller rod."
