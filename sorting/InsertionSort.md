# Insertion Sort

**Idea:** Like sorting playing cards in hand: take the next card and insert it into the right place in the already sorted part.

**Steps:** For `i = 1..n-1`: `key = a[i]`; shift elements of `[0..i-1]` that are greater than `key` one step right; drop `key` into the gap.

**Intuition:** The prefix `[0..i-1]` is always sorted. Inserting one element keeps it sorted.

**Complexity:** Worst/avg O(n²), best O(n) (already sorted). Space O(1).
**Stable?** Yes (shift only while strictly greater).

**When to use:** Small or nearly sorted arrays. Real libraries use it for tiny partitions inside hybrid sorts (e.g. Timsort).

**Edge cases:** Empty, single element, already sorted, reverse sorted (worst), duplicates.

**Interview traps**
- Use `a[j] > key` (strict) for stability.
- Save `key` before shifting, or you overwrite it.
- Insert at `a[j+1]` after the loop, since `j` ends one position too far left.

**How to explain:** "Grow a sorted prefix one element at a time by shifting larger elements right and dropping the new element in. It's great on nearly sorted data."
