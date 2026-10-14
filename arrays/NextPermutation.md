# Next Permutation (LC 31)

**Problem:** Rearrange in place into the next lexicographically larger permutation. If none exists (descending), wrap to the smallest (ascending).

**Brute force:** Generate all permutations in order and pick the next → O(n!·n).
**Optimal (3 steps):**
1. From the right, find the first index `i` with `a[i] < a[i+1]` (the **pivot**). If none, the array is fully descending, so just reverse it.
2. From the right, find the first `j` with `a[j] > a[i]` and **swap** them.
3. **Reverse** the suffix after `i`.

**Intuition:** The suffix after the pivot is descending (the largest arrangement of those elements). To go up by the smallest step, bump the pivot to the next larger value from the suffix, then make the suffix as small as possible, which means ascending (reverse it).

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Descending array (wraps around), single element, duplicates (`[1,5,1]` → `[5,1,1]`), already the last permutation.

**Interview traps**
- Use `>=` in step 1 and `<=` in step 2 so duplicates are handled.
- If no pivot is found (`i = -1`), `reverse(a, 0, n-1)` handles the wrap-around.
- Know how to explain why the suffix reversal gives the *smallest* larger arrangement.

**How to explain:** "Find the rightmost ascent, swap that element with the next larger one from the right side, then reverse the tail so it's as small as possible."
