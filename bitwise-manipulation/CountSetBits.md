# Count the Number of Set Bits (Hamming Weight, LC 191)

**Problem:** Count the 1-bits in the binary representation of `n`.

**Brute force:** Check each of the 32 bits: `count += n & 1; n >>>= 1` → O(32).
**Optimal (Brian Kernighan):** `n &= (n - 1)` removes the lowest set bit each time. Loop until `n == 0` → O(k) where **k = number of set bits**.

**Intuition:** `n - 1` flips the lowest set bit to 0 and the zeros below it to 1, so `n & (n - 1)` erases exactly that lowest set bit and nothing else.

**Extras:**
- `Integer.bitCount(n)` is the built-in (uses a bit-parallel popcount).
- **Counting Bits (LC 338):** for all numbers 0..n use `dp[i] = dp[i >> 1] + (i & 1)` → O(n).
- Lookup table for 8 or 16 bits at a time.

**Complexity:** Time O(k), Space O(1).

**Edge cases:** `0` (0), `-1` (32 set bits), `Integer.MAX_VALUE` (31), powers of two (1).

**Interview traps**
- In the shifting version use **`>>>`**. With `>>` a negative number never reaches 0 and the loop runs forever.
- Kernighan's loop terminates for negatives too (at most 32 iterations).
- Know the O(1)-per-number DP for the "count bits for every number" variant.
- Hamming distance = `bitCount(a ^ b)` (see Minimum Bit Flips).

**How to explain:** "Each `n & (n-1)` drops the lowest set bit, so the number of iterations equals the number of set bits."
