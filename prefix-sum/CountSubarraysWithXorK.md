# Count Subarrays with XOR K

**Problem:** Count subarrays whose XOR equals `k`.

**Brute force:** All subarrays with a running XOR → O(n²).
**Optimal:** Prefix XOR + HashMap of counts → O(n) time, O(n) space.

**Approach:** Let `P` be the XOR of the first `i` elements. The XOR of `a[j+1..i]` is `P[i] ^ P[j]`. We need that to equal `k`, so `P[j] = P[i] ^ k`. For each `i`, add `count[P ^ k]`, then record `P`. Seed `{0 → 1}`.

**Intuition:** XOR is its own inverse (`x ^ x = 0`), so XOR behaves like subtraction for prefix tricks, the same structure as prefix **sums**.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** `k = 0` (subarrays with XOR 0), all zeros (`[0,0]`, k=0 → 3), a single element equal to `k`, no match.

**Interview traps**
- The lookup key is `prefix ^ k` (not `prefix - k`).
- Look up before inserting the current prefix, and seed `{0 → 1}`.
- No overflow concerns for XOR, unlike sums.
- Recognise the family: sum K, XOR K, divisible by K (prefix mod), and equal 0/1 counts (map 0 to -1) all use the same template.

**How to explain:** "Same as counting subarrays with sum k, but with XOR. Since XOR undoes itself, the subarray XOR is the XOR of two prefixes, so I look up `prefix ^ k` in a count map."
