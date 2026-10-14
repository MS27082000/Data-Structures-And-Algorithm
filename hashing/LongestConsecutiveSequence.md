# Longest Consecutive Sequence (LC 128)

**Problem:** Unsorted array; return the length of the longest run of consecutive integers (like `1,2,3,4`). Must be **O(n)**.

**Brute force:** For each number, repeatedly search the array for `x+1`, `x+2`… → O(n²) or O(n³).
**Better:** Sort and count runs → O(n log n) time (skip duplicates). Fine, but it isn't O(n).
**Optimal:** Put everything in a `HashSet`. Only start counting from a number with **no predecessor** (`x-1` absent) and extend while `x+1` exists → O(n) time, O(n) space.

**Intuition:** Every sequence has exactly one start, the number whose `x-1` is missing. Starting only there means each element is visited at most twice (once as a candidate, once while extending), so it's linear even though there is a nested loop.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Empty array (0), duplicates (`[1,0,1,2]` → 3), negatives, a single element, all elements the same.

**Interview traps**
- Without the "is it a start?" check, you re-walk the same sequence from every element → O(n²). This check is the whole point.
- Iterate over the **set**, not the array, so duplicates don't repeat work.
- Sorting gives O(n log n). Mention it, but say hashing meets the O(n) requirement.

**How to explain:** "Hash all numbers. For each number whose predecessor isn't in the set, walk upward while the next number exists. Each number is part of exactly one walk, so it's O(n)."
