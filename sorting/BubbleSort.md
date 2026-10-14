# Bubble Sort

**Idea:** Compare adjacent elements and swap if out of order. Large values "bubble" to the end.

**Steps:** For `end = n-1` down to 1: for `j = 0..end-1`, swap `a[j], a[j+1]` if `a[j] > a[j+1]`. After each pass the max of the unsorted part sits at `end`.

**Intuition:** One full pass guarantees the largest unsorted element reaches its final spot.

**Optimisation:** If a whole pass does **no swap**, the array is sorted, so stop. This makes the best case O(n).

**Complexity:** Worst/avg O(n²), best O(n) (with the flag). Space O(1).
**Stable?** Yes (only swaps strictly greater neighbours).

**Edge cases:** Empty, single element, already sorted, reverse sorted (worst), duplicates.

**Interview traps**
- Forgetting the `swapped` flag, so the best case is not O(n).
- Inner loop bound shrinks each pass (`j < end`), not `n-1` always.
- Use `>` not `>=`, or it loses stability.

**How to explain:** "Repeatedly swap adjacent out-of-order pairs. Each pass fixes the largest element at the end. With an early-exit flag it's O(n) on sorted input."
