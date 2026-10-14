# Count Number of Nice Subarrays (LC 1248)

**Problem:** A subarray is **nice** if it contains exactly `k` **odd** numbers. Count nice subarrays.

**Brute force:** All subarrays, counting odds → O(n²).
**Optimal:** Map each number to `1` (odd) or `0` (even). The task becomes **"Binary Subarrays With Sum = k"**: `exactly(k) = atMost(k) − atMost(k − 1)` with a sliding window → O(n), O(1).
**Alternative:** Prefix count of odds + HashMap, as in Count Subarrays with Sum K.

**Intuition:** Only the parity matters. Evens are free "padding" that can extend a window on either side without changing the odd count.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `k = 0` (subarrays of only evens), no odd numbers when `k ≥ 1` (0), all odd numbers, negative odd numbers (`x & 1` works for negatives).

**Interview traps**
- Use `x & 1` (or `x % 2 != 0`), not `x % 2 == 1`, which fails for negative numbers.
- `atMost(k − 1)` with `k = 0` must return 0.
- Recognise the reduction: this is one transformation away from Binary Subarrays With Sum.

**How to explain:** "I only care whether each number is odd, so I turn the problem into counting subarrays with exactly k ones. I count 'at most k' and subtract 'at most k − 1' using a sliding window."
