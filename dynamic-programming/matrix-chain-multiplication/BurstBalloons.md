# Burst Balloons (LC 312)

**Problem:** Bursting balloon i earns `nums[i-1]*nums[i]*nums[i+1]` (current neighbours; outside = 1). Maximise coins.

**Intuition:** Think **backwards**: pick the **last** balloon k burst in a range (i, j). Its neighbours are the borders i and j, and the left and right parts are independent. `dp[i][j] = max over k of dp[i][k] + dp[k][j] + a[i]*a[k]*a[j]` with `a = [1, nums..., 1]`.

**Brute force:** All burst orders, O(n!).
**Optimised:** O(n^3) time, O(n^2) space.

**Edge cases:** One balloon, empty array, zeros.

**Interview traps**
- Choosing the **first** balloon to burst makes the sub-problems dependent - that is the trap.
- Pad both ends with 1.

**How to explain:** "I choose which balloon pops last, because then everything on each side pops independently with fixed borders."
