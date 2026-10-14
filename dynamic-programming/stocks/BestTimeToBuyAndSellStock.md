# Best Time to Buy and Sell Stock (LC 121)

**Problem:** One buy and one later sell. Maximum profit (0 if none).

**Intuition:** For each day as the sell day, the best buy is the **cheapest earlier price**. Track the running minimum and the best difference.

**Brute force:** Every pair (i<j), O(n^2).
**Optimised:** One pass, O(n) time, O(1) space.

**Edge cases:** Falling prices -> 0. One day -> 0. Empty array.

**Interview traps**
- You cannot sell before you buy: the min must come from earlier days (so `[2,4,1]` is 2, not 3).
- Return 0, not a negative.

**How to explain:** "Keep the lowest price so far; each day, profit if I sold now is price minus that minimum. Keep the best."
