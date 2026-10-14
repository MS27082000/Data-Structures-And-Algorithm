# Aggressive Cows

**Problem:** Stalls at given positions, `k` cows. Place them so the **minimum** distance between any two cows is as **large** as possible. Return that distance.

**Brute force:** Try every distance from 1 to `max - min`, checking placement greedily → O(n · range).
**Optimal:** Sort, then **binary search on the distance** `[1, max - min]` → O(n log n + n log range).

**Feasibility check (greedy):** Put the first cow in the first stall. For each next stall, place a cow if it is at least `dist` from the last cow. If you place `>= k` cows → feasible.

**Intuition:** If cows can be placed with spacing `d`, they can be placed with any smaller spacing. So feasibility is `true … true false … false`, and we want the **last true** (maximise).

**Complexity:** Time O(n log n + n log range), Space O(1) extra.

**Edge cases:** `k = 2` (answer `max - min`), `k = n` (smallest gap), unsorted input, duplicates.

**Interview traps**
- **Sort first.** The input is usually unsorted.
- This is a "maximise the minimum" problem, so on a feasible mid set `ans = mid; low = mid + 1`.
- Greedy placement (earliest possible stall) is optimal.
- Opposite shape to "minimise the maximum" problems like Painter's Partition.

**How to explain:** "I binary search the distance. For each distance I greedily place cows as early as possible and count them. If I can fit k, I try a bigger distance."
