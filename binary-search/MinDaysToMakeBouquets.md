# Minimum Days to Make M Bouquets (LC 1482)

**Problem:** `bloomDay[i]` is the day flower `i` blooms. A bouquet needs `k` **adjacent** bloomed flowers. Find the minimum day to make `m` bouquets, or -1.

**Brute force:** Try every day from min to max and count bouquets → O(n · range).
**Optimal:** **Binary search on the day.** If `m` bouquets are possible on day `d`, they're possible on any later day → O(n log range).

**Feasibility check:** Scan the array. Count a run of consecutive flowers with `bloomDay <= day`. Every time the run reaches `k`, make a bouquet and reset. A flower not yet bloomed resets the run.

**Intuition:** Monotonic in time, and the check is a simple greedy scan.

**Complexity:** Time O(n log(max - min)), Space O(1).

**Edge cases:** `m * k > n` → -1 immediately, `k = 1`, one bouquet, all flowers bloom the same day.

**Interview traps**
- Check `m * k > n` first. Use `long`, since `m * k` can overflow `int`.
- Reset the run when a flower hasn't bloomed (adjacency).
- Reset the run to 0 after forming a bouquet (flowers can't be reused).
- Search range: `[min(bloomDay), max(bloomDay)]`.

**How to explain:** "More days only helps, so I binary search the day. For a given day I scan greedily, forming a bouquet whenever I see k adjacent bloomed flowers."
