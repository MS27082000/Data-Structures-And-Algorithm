# 3Sum (LC 15)

**Problem:** Find all **unique** triplets in the array that sum to 0.

**Brute force:** Three nested loops + a set to dedupe → O(n³).
**Middle option:** Fix `i`, use a HashSet for the rest → O(n²) but dedupe is messy and uses extra space.

**Approach:** Sort. Fix `i`, then run Two Sum II on the rest (`left=i+1`, `right=n-1`) targeting `-nums[i]`.
- sum < 0 → `left++`; sum > 0 → `right--`
- sum == 0 → record, move both, **skip duplicates**.

**Intuition:** Sorting enables the two-pointer trick *and* puts duplicates side by side, so skipping them is trivial. Reduces 3Sum to n × (Two Sum II).

**Complexity:** Time O(n²) (sort is O(n log n), dominated). Space O(1) extra (ignoring output and sort).

**Edge cases:** `[]`, fewer than 3 elements, all zeros (`[0,0,0,0]` → one triplet), all positive or all negative, many duplicates.

**Interview traps**
- **Duplicate handling** is the whole question: skip repeated `nums[i]`, and after a match skip repeated `left` and `right`.
- Skip duplicates *after* recording a match, not before.
- Early break when `nums[i] > 0` is an optimisation, not required.
- Sorting changes order, which is fine since the output is values and not indices.

**How to explain:** "Sort, fix one number, then two pointers for the other two. Sorting makes duplicate skipping easy. O(n²) time, no extra space beyond output."
