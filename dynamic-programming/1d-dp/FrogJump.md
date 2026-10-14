# Frog Jump (Striver DP 3)

**Problem:** Heights `h[0..n-1]`. The frog starts at 0 and can jump to i+1 or i+2. A jump from i to j costs `|h[i] - h[j]|`. Minimum total energy to reach n-1.

**Intuition:** `f(i)` = min cost to reach stair i. You arrive from i-1 or i-2: `f(i) = min(f(i-1) + |h[i]-h[i-1]|, f(i-2) + |h[i]-h[i-2]|)`. `f(0) = 0`.

**Brute force:** Recursion, O(2^n).
**Optimised:** Tabulation with two variables, O(n) time, O(1) space.

**Edge cases:** n = 1 -> 0. n = 2 -> only one possible jump. Equal heights cost 0.

**Interview traps**
- The i-2 option exists only when i >= 2.
- Greedy "always take the cheaper next jump" is wrong - a costly step can enable a cheaper later one.

**How to explain:** "Cost to reach i is the cheaper of coming from i-1 or i-2. I keep the last two costs, so it is O(n) time and O(1) space."
