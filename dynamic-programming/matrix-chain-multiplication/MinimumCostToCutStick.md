# Minimum Cost to Cut a Stick (LC 1547)

**Problem:** Cutting a stick costs its current length. Make all given cuts in the best order.

**Intuition:** Add the ends 0 and n and sort the cuts. `dp[i][j]` = min cost to make all cuts strictly between `c[i]` and `c[j]`. Choose which cut k happens **first** in that piece: `dp[i][j] = (c[j] - c[i]) + min over k of dp[i][k] + dp[k][j]`. Same shape as MCM / Burst Balloons.

**Brute force:** All cut orders, O(m!).
**Optimised:** O(m^3) time, O(m^2) space.

**Edge cases:** No cuts -> 0. One cut -> n.

**Interview traps**
- Sort the cuts and add both ends.
- The cost is the length of the piece being cut at that moment.

**How to explain:** "The first cut splits the stick into two independent parts, so I try every first cut and add the stick length."
