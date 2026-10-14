# Binary Subarrays With Sum (LC 930)

**Problem:** A binary array and an integer `goal`. Count subarrays whose sum equals `goal`.

**Brute force:** All subarrays → O(n²).
**Optimal (sliding window):** `exactly(goal) = atMost(goal) − atMost(goal − 1)`. `atMost(g)` slides a window: expand `right`, shrink while `sum > g`, add `right − left + 1` (every subarray ending at `right`) → O(n), O(1).
**Alternative (prefix sum + HashMap):** count prefixes equal to `prefix − goal` → O(n), O(n) space. This also works with negatives. See [Count Subarrays with Sum K](../prefix-sum/CountSubarraysWithSumK.md).

**Intuition:** "Exactly" isn't monotonic, but "at most" is: shrinking a window can't increase its sum. Subtracting the two at-most counts leaves only windows with sum exactly `goal`.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `goal = 0` (count runs of zeros: `[0,0,0,0,0]` → 15), `goal` larger than the total (0), single element.

**Interview traps**
- **`goal − 1` can be −1** for `goal = 0`. Return 0 from `atMost` when `goal < 0`.
- The sliding window requires **non-negative** values. With negatives use prefix sums.
- Add `right − left + 1` per step (all starts), not 1.

**How to explain:** "Counting subarrays with exactly `goal` is hard to do directly, so I count those with at most `goal` and subtract those with at most `goal − 1`, each with a sliding window."
