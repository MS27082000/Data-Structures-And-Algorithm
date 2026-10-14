# Sort Colors – Dutch National Flag (LC 75)

**Problem:** Array of 0s, 1s, 2s. Sort in-place without a library sort.

**Brute force:** Library sort → O(n log n).
**Better:** Counting sort (count 0/1/2, then rewrite) → O(n) but **two passes**.

**Approach (one pass, 3 pointers):** `low`, `mid`, `high`.
- `0` → swap with `low`; `low++, mid++`
- `1` → `mid++`
- `2` → swap with `high`; `high--` (**don't** move `mid`)

Loop while `mid <= high`.

**Intuition:** Maintain four regions: `[0..low)` = 0s, `[low..mid)` = 1s, `[mid..high]` = unknown, `(high..end]` = 2s. Each step shrinks the unknown region.

**Complexity:** Time O(n), Space O(1), single pass.

**Edge cases:** Single element, all same value, already sorted, reverse sorted.

**Interview traps**
- After swapping with `high`, the value that arrives at `mid` is **unchecked**, so don't increment `mid`.
- After swapping with `low`, the value coming to `mid` is always a 1 (known), so `mid++` is safe.
- Loop condition is `mid <= high` (not `<`).
- Follow-up: "one pass?" is the main reason this question exists.

**How to explain:** "Three pointers partition the array into 0s, 1s, and 2s around an unknown middle. I process `mid` until it crosses `high`. One pass, no extra space."
