# Rearrange Array Elements by Sign (LC 2149)

**Problem:** Equal numbers of positives and negatives. Rearrange so signs alternate, starting with positive, preserving the relative order within each sign.

**Brute force:** Split into positive and negative lists, then interleave → O(n) time, O(n) space (two passes).
**Optimal (one pass):** Two write indices into a result array: positives at `0, 2, 4…`, negatives at `1, 3, 5…`.

**Intuition:** The final position of the k-th positive is `2k`, and of the k-th negative is `2k+1`. So you can place each element directly as you scan.

**Complexity:** Time O(n), Space O(n) for the result array.

**Edge cases:** Size 2, already alternating, all positives first then all negatives.

**Interview traps**
- In-place O(1) space **while keeping order** is hard (needs rotations, O(n²)). Say that clearly.
- **Follow-up:** unequal counts of positives and negatives. Place the alternating part, then append the leftover elements of the larger group at the end.
- Zero is treated as non-positive here. Check the problem statement.

**How to explain:** "Positives go to even slots, negatives to odd slots, filled in the order they appear. One pass, extra array for the result."
