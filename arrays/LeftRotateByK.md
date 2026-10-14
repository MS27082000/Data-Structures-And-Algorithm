# Left Rotate Array by K Places

**Problem:** Rotate left by `k`: `[1..7], k=3` → `[4,5,6,7,1,2,3]`.

**Brute force:** Repeat "rotate by one" k times → O(n·k).
**Better:** Temp array: first `k` elements saved, shift the rest left, put the saved ones at the end → O(n) time, O(k) space.
**Optimal (reversal algorithm):** `reverse(0..k-1)`, `reverse(k..n-1)`, `reverse(0..n-1)` → O(n) time, O(1) space.

**Intuition:** Reversing the two blocks separately and then the whole array swaps the blocks `A B → B A`, because `(A^r B^r)^r = B A`.

**Edge cases:** `k = 0`, `k = n`, `k > n` (use `k % n`), empty array, single element.

**Interview traps**
- Always do `k %= n` first.
- Right rotation by k = left rotation by `n - k` (LC 189). Know both directions.
- Be ready to derive why triple reverse works.

**How to explain:** "Reverse the first k, reverse the rest, then reverse the whole array. In place, linear time."
