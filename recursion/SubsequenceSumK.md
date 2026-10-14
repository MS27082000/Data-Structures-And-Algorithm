# Check if There Exists a Subsequence with Sum K

**Problem:** Is there any subsequence of the array with sum exactly `K`? (Optionally print one.)

**Brute force / standard:** Take / not-take recursion over all 2ⁿ subsequences → O(2ⁿ) time, O(n) stack.
**Key difference from "print all":** The function returns a **boolean**. As soon as one branch returns `true`, return `true` up the chain. Do not explore the rest.

**Approach:** `exists(index, remaining)`: if `remaining == 0` → true; if `index == n` → false; try take, then not-take, and return the OR.

**Intuition:** Same decision tree as generating all subsequences, but short-circuiting turns it into a search that stops early.

**Complexity:** Time O(2ⁿ) worst case, Space O(n).
**Better:** For non-negative numbers and small `K`, DP (subset sum) gives O(n·K).

**Edge cases:** `K = 0` (the empty subsequence qualifies), empty array, all numbers larger than `K`, negatives.

**Interview traps**
- **Base case choice:** checking `remaining == 0` early works, but if the array has zeros and you need a *count* it changes. For existence it's fine.
- **Pruning** (`remaining < 0 → return false`) is valid **only for positive numbers**.
- Undo the "take" if you track the actual subsequence.
- Mention the DP upgrade (Subset Sum) when asked about efficiency.

**How to explain:** "At each element I either include it or not. I search depth-first and return true the moment I hit the target sum, so I don't explore everything."
